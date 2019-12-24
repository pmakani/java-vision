/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.vision.it;

import static com.google.cloud.vision.v1.Feature.Type;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.ServiceOptions;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.vision.v1.AnnotateFileResponse;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.AsyncAnnotateFileRequest;
import com.google.cloud.vision.v1.AsyncAnnotateFileResponse;
import com.google.cloud.vision.v1.AsyncBatchAnnotateFilesResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.ColorInfo;
import com.google.cloud.vision.v1.CreateProductRequest;
import com.google.cloud.vision.v1.CropHint;
import com.google.cloud.vision.v1.CropHintsAnnotation;
import com.google.cloud.vision.v1.DeleteProductRequest;
import com.google.cloud.vision.v1.DominantColorsAnnotation;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.GcsDestination;
import com.google.cloud.vision.v1.GcsSource;
import com.google.cloud.vision.v1.GetProductRequest;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageContext;
import com.google.cloud.vision.v1.ImageSource;
import com.google.cloud.vision.v1.InputConfig;
import com.google.cloud.vision.v1.Likelihood;
import com.google.cloud.vision.v1.ListProductsRequest;
import com.google.cloud.vision.v1.LocalizedObjectAnnotation;
import com.google.cloud.vision.v1.LocationName;
import com.google.cloud.vision.v1.OperationMetadata;
import com.google.cloud.vision.v1.OutputConfig;
import com.google.cloud.vision.v1.Product;
import com.google.cloud.vision.v1.ProductName;
import com.google.cloud.vision.v1.ProductSearchClient;
import com.google.cloud.vision.v1.SafeSearchAnnotation;
import com.google.cloud.vision.v1.TextAnnotation;
import com.google.cloud.vision.v1.Vertex;
import com.google.cloud.vision.v1.WebDetection;
import com.google.cloud.vision.v1.WebDetectionParams;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.JsonFormat;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static ImageAnnotatorClient imageAnnotatorClient;
  private static ProductSearchClient productSearchClient;
  private static Product product;
  private static String formatProductName;
  private static String productName;
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String OUTPUT_PREFIX = "OCR_PDF_TEST_OUTPUT_" + ID;
  private static final String RESOURCES = "src/test/resources/";
  private static final String SAMPLE_BUCKET = "gs://cloud-samples-data/vision/";
  private static final String SAMPLE_URI =
      "https://storage-download.googleapis.com/cloud-samples-data/vision/";
  private static final String COMPUTE_REGION = "us-west1";
  private static final String LOCATION_NAME =
      LocationName.of(PROJECT_ID, COMPUTE_REGION).toString();
  private static final String PRODUCT_DISPLAY_NAME = "test-display-name-" + ID;
  private static final String PRODUCT_CATEGORY = "homegoods";
  private static final String PRODUCT_ID = "test-product-" + ID;
  private static final String KEY = "test-key-" + ID;
  private static final String VALUE = "test-value-" + ID;

  @BeforeClass
  public static void setUp() throws IOException {

    imageAnnotatorClient = ImageAnnotatorClient.create();

    productSearchClient = ProductSearchClient.create();
    // create product
    Product createProduct =
        Product.newBuilder()
            .setName(PRODUCT_ID)
            .setDisplayName(PRODUCT_DISPLAY_NAME)
            .setProductCategory(PRODUCT_CATEGORY)
            .build();
    CreateProductRequest productRequest =
        CreateProductRequest.newBuilder()
            .setParent(LOCATION_NAME)
            .setProduct(createProduct)
            .build();
    product = productSearchClient.createProduct(productRequest);
    productName = product.getName().substring(product.getName().lastIndexOf("/")).replace("/", "");
    formatProductName = ProductName.of(PROJECT_ID, COMPUTE_REGION, productName).toString();
  }

  @AfterClass
  public static void tearDown() {

    // delete product
    DeleteProductRequest request =
        DeleteProductRequest.newBuilder().setName(formatProductName).build();
    productSearchClient.deleteProduct(request);
    productSearchClient.close();

    imageAnnotatorClient.close();
  }

  @Test
  public void detectFacesTest() throws IOException {
    ByteString imgBytes =
        ByteString.readFrom(new FileInputStream(RESOURCES + "face_no_surprise.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.FACE_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    for (AnnotateImageResponse res : responses) {
      for (FaceAnnotation annotation : res.getFaceAnnotationsList()) {
        assertEquals(Likelihood.POSSIBLE, annotation.getAngerLikelihood());
        assertEquals(Likelihood.POSSIBLE, annotation.getJoyLikelihood());
        assertEquals(Likelihood.LIKELY, annotation.getSurpriseLikelihood());
      }
    }
  }

  @Test
  public void detectFacesGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder()
            .setGcsImageUri(SAMPLE_BUCKET + "face/face_no_surprise.jpg")
            .build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.FACE_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    for (AnnotateImageResponse res : responses) {
      for (FaceAnnotation annotation : res.getFaceAnnotationsList()) {
        assertEquals(Likelihood.POSSIBLE, annotation.getAngerLikelihood());
        assertEquals(Likelihood.POSSIBLE, annotation.getJoyLikelihood());
        assertEquals(Likelihood.LIKELY, annotation.getSurpriseLikelihood());
      }
    }
  }

  @Test
  public void detectLabelsTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "wakeupcat.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("Whiskers"));
  }

  @Test
  public void detectLabelsGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "label/wakeupcat.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("Whiskers"));
  }

  @Test
  public void detectLandmarksTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "landmark.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("Palace of Fine Arts"));
  }

  @Test
  public void detectLandmarksUrlTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setImageUri(SAMPLE_URI + "landmark/pofa.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("Palace of Fine Arts"));
  }

  @Test
  public void detectLandmarksGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "landmark/pofa.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLandmarkAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("Palace of Fine Arts"));
  }

  @Test
  public void detectLogosTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "logos.png"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.LOGO_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLogoAnnotationsList()) {
        assertEquals("Google", annotation.getDescription());
      }
    }
  }

  @Test
  public void detectLogosGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "logo/logo_google.png").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.LOGO_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getLogoAnnotationsList()) {
        assertEquals("Google", annotation.getDescription());
      }
    }
  }

  @Test
  public void detectTextTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "text.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("37%"));
  }

  @Test
  public void detectTextGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "text/screen.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
        actual.add(annotation.getDescription());
      }
    }
    assertTrue(actual.contains("37%"));
  }

  @Test
  public void detectPropertiesTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "landmark.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.IMAGE_PROPERTIES).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<Float> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      DominantColorsAnnotation colors = res.getImagePropertiesAnnotation().getDominantColors();
      for (ColorInfo color : colors.getColorsList()) {
        actual.add(color.getPixelFraction());
      }
    }
    assertTrue(actual.contains((float) 0.14140345));
  }

  @Test
  public void detectPropertiesGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "landmark/pofa.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.IMAGE_PROPERTIES).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<Float> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      DominantColorsAnnotation colors = res.getImagePropertiesAnnotation().getDominantColors();
      for (ColorInfo color : colors.getColorsList()) {
        actual.add(color.getPixelFraction());
      }
    }
    assertTrue(actual.contains((float) 0.14140345));
  }

  @Test
  public void detectSafeSearchTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "wakeupcat.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    for (AnnotateImageResponse res : responses) {
      SafeSearchAnnotation annotation = res.getSafeSearchAnnotation();
      assertEquals(Likelihood.VERY_UNLIKELY, annotation.getAdult());
      assertEquals(Likelihood.UNLIKELY, annotation.getRacy());
    }
  }

  @Test
  public void detectSafeSearchGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "label/wakeupcat.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    for (AnnotateImageResponse res : responses) {
      SafeSearchAnnotation annotation = res.getSafeSearchAnnotation();
      assertEquals(Likelihood.VERY_UNLIKELY, annotation.getAdult());
      assertEquals(Likelihood.UNLIKELY, annotation.getRacy());
    }
  }

  @Test
  public void detectWebDetectionsTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "landmark.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      WebDetection annotation = res.getWebDetection();
      for (WebDetection.WebEntity entity : annotation.getWebEntitiesList()) {
        actual.add(entity.getDescription());
      }
    }
    assertTrue(actual.contains("The Palace Of Fine Arts"));
  }

  @Test
  public void detectWebDetectionsGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "landmark/pofa.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      WebDetection annotation = res.getWebDetection();
      for (WebDetection.WebEntity entity : annotation.getWebEntitiesList()) {
        actual.add(entity.getDescription());
      }
    }
    assertTrue(actual.contains("The Palace Of Fine Arts"));
  }

  @Test
  public void detectWebEntitiesTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "city.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      for (WebDetection.WebEntity entity : imgResponse.getWebDetection().getWebEntitiesList()) {
        actual.add(entity.getDescription());
      }
    }
    assertTrue(actual.contains("Skyscraper"));
  }

  @Test
  public void detectWebEntitiesGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "landmark/pofa.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      for (WebDetection.WebEntity entity : imgResponse.getWebDetection().getWebEntitiesList()) {
        actual.add(entity.getDescription());
      }
    }
    assertTrue(actual.contains("The Palace Of Fine Arts"));
  }

  @Test
  public void detectWebEntitiesIncludeGeoResultsTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "city.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    WebDetectionParams webDetectionParams =
        WebDetectionParams.newBuilder().setIncludeGeoResults(true).build();
    ImageContext imageContext =
        ImageContext.newBuilder().setWebDetectionParams(webDetectionParams).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder()
            .addFeatures(feat)
            .setImageContext(imageContext)
            .setImage(img)
            .build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      for (WebDetection.WebEntity entity : imgResponse.getWebDetection().getWebEntitiesList()) {
        actual.add(entity.getDescription());
      }
    }
    assertTrue(actual.contains("Skyscraper"));
  }

  @Test
  public void detectWebEntitiesIncludeGeoResultsGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "landmark/pofa.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.WEB_DETECTION).build();
    WebDetectionParams webDetectionParams =
        WebDetectionParams.newBuilder().setIncludeGeoResults(true).build();
    ImageContext imageContext =
        ImageContext.newBuilder().setWebDetectionParams(webDetectionParams).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder()
            .addFeatures(feat)
            .setImageContext(imageContext)
            .setImage(img)
            .build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      for (WebDetection.WebEntity entity : imgResponse.getWebDetection().getWebEntitiesList()) {
        actual.add(entity.getDescription());
      }
    }
    assertTrue(actual.contains("The Palace Of Fine Arts"));
  }

  @Test
  public void detectCropHintsTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "wakeupcat.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.CROP_HINTS).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<Integer> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      CropHintsAnnotation annotation = imgResponse.getCropHintsAnnotation();
      for (CropHint hint : annotation.getCropHintsList()) {
        for (Vertex vertex : hint.getBoundingPoly().getVerticesList()) {
          actual.add(vertex.getX());
        }
      }
    }
    assertEquals(Arrays.asList(210, 476, 476, 210), actual);
  }

  @Test
  public void detectCropHintsGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "label/wakeupcat.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.CROP_HINTS).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<Integer> actual = new ArrayList<>();
    for (AnnotateImageResponse imgResponse : responses) {
      CropHintsAnnotation annotation = imgResponse.getCropHintsAnnotation();
      for (CropHint hint : annotation.getCropHintsList()) {
        for (Vertex vertex : hint.getBoundingPoly().getVerticesList()) {
          actual.add(vertex.getX());
        }
      }
    }
    assertEquals(Arrays.asList(210, 476, 476, 210), actual);
  }

  @Test
  public void detectDocumentTextTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "text.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    String actual = "";
    for (AnnotateImageResponse imgResponse : responses) {
      TextAnnotation annotation = imgResponse.getFullTextAnnotation();
      actual = annotation.getText();
    }
    assertTrue(actual.contains("After preparation is complete"));
  }

  @Test
  public void detectDocumentTextGcs() {
    ImageSource imgSource =
        ImageSource.newBuilder().setGcsImageUri(SAMPLE_BUCKET + "text/screen.jpg").build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    String actual = "";
    for (AnnotateImageResponse imgResponse : responses) {
      TextAnnotation annotation = imgResponse.getFullTextAnnotation();
      actual = annotation.getText();
    }
    assertTrue(actual.contains("After preparation is complete"));
  }

  @Test
  public void detectDocumentsGcsTest() throws Exception {
    String gcsDestinationPath = "gs://" + PROJECT_ID + "/" + OUTPUT_PREFIX + "/";
    GcsSource gcsSource =
        GcsSource.newBuilder().setUri(SAMPLE_BUCKET + "document/custom_0773375000.pdf").build();
    InputConfig inputConfig =
        InputConfig.newBuilder()
            .setMimeType("application/pdf") // Supported MimeTypes: "application/pdf", "image/tiff"
            .setGcsSource(gcsSource)
            .build();
    GcsDestination gcsDestination = GcsDestination.newBuilder().setUri(gcsDestinationPath).build();
    OutputConfig outputConfig =
        OutputConfig.newBuilder().setBatchSize(2).setGcsDestination(gcsDestination).build();
    Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
    AsyncAnnotateFileRequest request =
        AsyncAnnotateFileRequest.newBuilder()
            .addFeatures(feat)
            .setInputConfig(inputConfig)
            .setOutputConfig(outputConfig)
            .build();
    OperationFuture<AsyncBatchAnnotateFilesResponse, OperationMetadata> response =
        imageAnnotatorClient.asyncBatchAnnotateFilesAsync(
            ImmutableList.<AsyncAnnotateFileRequest>of(request));
    List<AsyncAnnotateFileResponse> result = response.get(180, TimeUnit.SECONDS).getResponsesList();
    Storage storage = StorageOptions.getDefaultInstance().getService();
    Pattern pattern = Pattern.compile("gs://([^/]+)/(.+)");
    Matcher matcher = pattern.matcher(gcsDestinationPath);
    if (matcher.find()) {
      String bucketName = matcher.group(1);
      String prefix = matcher.group(2);
      Bucket bucket = storage.get(bucketName);
      com.google.api.gax.paging.Page<Blob> pageList =
          bucket.list(Storage.BlobListOption.prefix(prefix));
      Blob firstOutputFile = null;
      for (Blob blob : pageList.iterateAll()) {
        if (firstOutputFile == null) {
          firstOutputFile = blob;
        }
      }
      String jsonContents = new String(firstOutputFile.getContent());
      AnnotateFileResponse.Builder builder = AnnotateFileResponse.newBuilder();
      JsonFormat.parser().merge(jsonContents, builder);
      AnnotateFileResponse annotateFileResponse = builder.build();
      AnnotateImageResponse annotateImageResponse = annotateFileResponse.getResponses(0);
      assertTrue(
          annotateImageResponse
              .getFullTextAnnotation()
              .getText()
              .contains("OIL, GAS AND MINERAL LEASE"));
      com.google.api.gax.paging.Page<Blob> blobs =
          storage.list(
              PROJECT_ID,
              Storage.BlobListOption.currentDirectory(),
              Storage.BlobListOption.prefix(OUTPUT_PREFIX + "/"));
      for (Blob blob : blobs.iterateAll()) {
        blob.delete();
      }
    }
  }

  @Test
  public void detectLocalizedObjectsTest() throws IOException {
    ByteString imgBytes = ByteString.readFrom(new FileInputStream(RESOURCES + "puppies.jpg"));
    Image img = Image.newBuilder().setContent(imgBytes).build();
    Feature feat = Feature.newBuilder().setType(Type.OBJECT_LOCALIZATION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
        actual.add(entity.getName());
      }
    }
    assertTrue(actual.contains("Dog"));
  }

  @Test
  public void detectLocalizedObjectsGcsTest() {
    ImageSource imgSource =
        ImageSource.newBuilder()
            .setGcsImageUri(SAMPLE_BUCKET + "object_localization/puppies.jpg")
            .build();
    Image img = Image.newBuilder().setSource(imgSource).build();
    Feature feat = Feature.newBuilder().setType(Type.OBJECT_LOCALIZATION).build();
    AnnotateImageRequest request =
        AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
    BatchAnnotateImagesResponse response =
        imageAnnotatorClient.batchAnnotateImages(ImmutableList.<AnnotateImageRequest>of(request));
    List<AnnotateImageResponse> responses = response.getResponsesList();
    List<String> actual = new ArrayList<>();
    for (AnnotateImageResponse res : responses) {
      for (LocalizedObjectAnnotation entity : res.getLocalizedObjectAnnotationsList()) {
        actual.add(entity.getName());
      }
    }
    assertTrue(actual.contains("Dog"));
  }

  @Test
  public void listProductsTest() {
    ListProductsRequest request = ListProductsRequest.newBuilder().setParent(LOCATION_NAME).build();
    for (Product actualProduct : productSearchClient.listProducts(request).iterateAll()) {
      if (product.getName().equals(actualProduct.getName())) {
        assertEquals(PRODUCT_DISPLAY_NAME, actualProduct.getDisplayName());
        assertEquals(PRODUCT_CATEGORY, actualProduct.getProductCategory());
      }
    }
  }

  @Test
  public void getProductTest() {
    GetProductRequest request = GetProductRequest.newBuilder().setName(formatProductName).build();
    Product actualProduct = productSearchClient.getProduct(request);
    assertEquals(product.getName(), actualProduct.getName());
    assertEquals(PRODUCT_DISPLAY_NAME, actualProduct.getDisplayName());
    assertEquals(PRODUCT_CATEGORY, actualProduct.getProductCategory());
  }
}
