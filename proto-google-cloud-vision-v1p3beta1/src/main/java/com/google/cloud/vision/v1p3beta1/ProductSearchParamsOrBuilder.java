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
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/vision/v1p3beta1/product_search.proto

package com.google.cloud.vision.v1p3beta1;

public interface ProductSearchParamsOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1p3beta1.ProductSearchParams)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The resource name of the catalog to search.
   * Format is: `productSearch/catalogs/CATALOG_NAME`.
   * </pre>
   *
   * <code>string catalog_name = 1;</code>
   *
   * @return The catalogName.
   */
  java.lang.String getCatalogName();
  /**
   *
   *
   * <pre>
   * The resource name of the catalog to search.
   * Format is: `productSearch/catalogs/CATALOG_NAME`.
   * </pre>
   *
   * <code>string catalog_name = 1;</code>
   *
   * @return The bytes for catalogName.
   */
  com.google.protobuf.ByteString getCatalogNameBytes();

  /**
   *
   *
   * <pre>
   * The category to search in.
   * Optional. It is inferred by the system if it is not specified.
   * [Deprecated] Use `product_category`.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.ProductSearchCategory category = 2;</code>
   *
   * @return The enum numeric value on the wire for category.
   */
  int getCategoryValue();
  /**
   *
   *
   * <pre>
   * The category to search in.
   * Optional. It is inferred by the system if it is not specified.
   * [Deprecated] Use `product_category`.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.ProductSearchCategory category = 2;</code>
   *
   * @return The category.
   */
  com.google.cloud.vision.v1p3beta1.ProductSearchCategory getCategory();

  /**
   *
   *
   * <pre>
   * The product category to search in.
   * Optional. It is inferred by the system if it is not specified.
   * Supported values are `bag`, `shoe`, `sunglasses`, `dress`, `outerwear`,
   * `skirt`, `top`, `shorts`, and `pants`.
   * </pre>
   *
   * <code>string product_category = 5;</code>
   *
   * @return The productCategory.
   */
  java.lang.String getProductCategory();
  /**
   *
   *
   * <pre>
   * The product category to search in.
   * Optional. It is inferred by the system if it is not specified.
   * Supported values are `bag`, `shoe`, `sunglasses`, `dress`, `outerwear`,
   * `skirt`, `top`, `shorts`, and `pants`.
   * </pre>
   *
   * <code>string product_category = 5;</code>
   *
   * @return The bytes for productCategory.
   */
  com.google.protobuf.ByteString getProductCategoryBytes();

  /**
   *
   *
   * <pre>
   * The bounding polygon around the area of interest in the image.
   * Optional. If it is not specified, system discretion will be applied.
   * [Deprecated] Use `bounding_poly`.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.NormalizedBoundingPoly normalized_bounding_poly = 3;
   * </code>
   *
   * @return Whether the normalizedBoundingPoly field is set.
   */
  boolean hasNormalizedBoundingPoly();
  /**
   *
   *
   * <pre>
   * The bounding polygon around the area of interest in the image.
   * Optional. If it is not specified, system discretion will be applied.
   * [Deprecated] Use `bounding_poly`.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.NormalizedBoundingPoly normalized_bounding_poly = 3;
   * </code>
   *
   * @return The normalizedBoundingPoly.
   */
  com.google.cloud.vision.v1p3beta1.NormalizedBoundingPoly getNormalizedBoundingPoly();
  /**
   *
   *
   * <pre>
   * The bounding polygon around the area of interest in the image.
   * Optional. If it is not specified, system discretion will be applied.
   * [Deprecated] Use `bounding_poly`.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.NormalizedBoundingPoly normalized_bounding_poly = 3;
   * </code>
   */
  com.google.cloud.vision.v1p3beta1.NormalizedBoundingPolyOrBuilder
      getNormalizedBoundingPolyOrBuilder();

  /**
   *
   *
   * <pre>
   * The bounding polygon around the area of interest in the image.
   * Optional. If it is not specified, system discretion will be applied.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.BoundingPoly bounding_poly = 9;</code>
   *
   * @return Whether the boundingPoly field is set.
   */
  boolean hasBoundingPoly();
  /**
   *
   *
   * <pre>
   * The bounding polygon around the area of interest in the image.
   * Optional. If it is not specified, system discretion will be applied.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.BoundingPoly bounding_poly = 9;</code>
   *
   * @return The boundingPoly.
   */
  com.google.cloud.vision.v1p3beta1.BoundingPoly getBoundingPoly();
  /**
   *
   *
   * <pre>
   * The bounding polygon around the area of interest in the image.
   * Optional. If it is not specified, system discretion will be applied.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.BoundingPoly bounding_poly = 9;</code>
   */
  com.google.cloud.vision.v1p3beta1.BoundingPolyOrBuilder getBoundingPolyOrBuilder();

  /**
   *
   *
   * <pre>
   * Specifies the verbosity of the  product search results.
   * Optional. Defaults to `BASIC`.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.ProductSearchResultsView view = 4;</code>
   *
   * @return The enum numeric value on the wire for view.
   */
  int getViewValue();
  /**
   *
   *
   * <pre>
   * Specifies the verbosity of the  product search results.
   * Optional. Defaults to `BASIC`.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p3beta1.ProductSearchResultsView view = 4;</code>
   *
   * @return The view.
   */
  com.google.cloud.vision.v1p3beta1.ProductSearchResultsView getView();

  /**
   *
   *
   * <pre>
   * The resource name of a
   * [ProductSet][google.cloud.vision.v1p3beta1.ProductSet] to be searched for
   * similar images.
   * Format is:
   * `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`.
   * </pre>
   *
   * <code>string product_set = 6;</code>
   *
   * @return The productSet.
   */
  java.lang.String getProductSet();
  /**
   *
   *
   * <pre>
   * The resource name of a
   * [ProductSet][google.cloud.vision.v1p3beta1.ProductSet] to be searched for
   * similar images.
   * Format is:
   * `projects/PROJECT_ID/locations/LOC_ID/productSets/PRODUCT_SET_ID`.
   * </pre>
   *
   * <code>string product_set = 6;</code>
   *
   * @return The bytes for productSet.
   */
  com.google.protobuf.ByteString getProductSetBytes();

  /**
   *
   *
   * <pre>
   * The list of product categories to search in. Currently, we only consider
   * the first category, and either "homegoods" or "apparel" should be
   * specified.
   * </pre>
   *
   * <code>repeated string product_categories = 7;</code>
   *
   * @return A list containing the productCategories.
   */
  java.util.List<java.lang.String> getProductCategoriesList();
  /**
   *
   *
   * <pre>
   * The list of product categories to search in. Currently, we only consider
   * the first category, and either "homegoods" or "apparel" should be
   * specified.
   * </pre>
   *
   * <code>repeated string product_categories = 7;</code>
   *
   * @return The count of productCategories.
   */
  int getProductCategoriesCount();
  /**
   *
   *
   * <pre>
   * The list of product categories to search in. Currently, we only consider
   * the first category, and either "homegoods" or "apparel" should be
   * specified.
   * </pre>
   *
   * <code>repeated string product_categories = 7;</code>
   *
   * @param index The index of the element to return.
   * @return The productCategories at the given index.
   */
  java.lang.String getProductCategories(int index);
  /**
   *
   *
   * <pre>
   * The list of product categories to search in. Currently, we only consider
   * the first category, and either "homegoods" or "apparel" should be
   * specified.
   * </pre>
   *
   * <code>repeated string product_categories = 7;</code>
   *
   * @param index The index of the value to return.
   * @return The bytes of the productCategories at the given index.
   */
  com.google.protobuf.ByteString getProductCategoriesBytes(int index);

  /**
   *
   *
   * <pre>
   * The filtering expression. This can be used to restrict search results based
   * on Product labels. We currently support an AND of OR of key-value
   * expressions, where each expression within an OR must have the same key.
   * For example, "(color = red OR color = blue) AND brand = Google" is
   * acceptable, but not "(color = red OR brand = Google)" or "color: red".
   * </pre>
   *
   * <code>string filter = 8;</code>
   *
   * @return The filter.
   */
  java.lang.String getFilter();
  /**
   *
   *
   * <pre>
   * The filtering expression. This can be used to restrict search results based
   * on Product labels. We currently support an AND of OR of key-value
   * expressions, where each expression within an OR must have the same key.
   * For example, "(color = red OR color = blue) AND brand = Google" is
   * acceptable, but not "(color = red OR brand = Google)" or "color: red".
   * </pre>
   *
   * <code>string filter = 8;</code>
   *
   * @return The bytes for filter.
   */
  com.google.protobuf.ByteString getFilterBytes();
}
