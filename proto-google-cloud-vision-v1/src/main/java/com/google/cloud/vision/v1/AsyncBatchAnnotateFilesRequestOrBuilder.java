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
// source: google/cloud/vision/v1/image_annotator.proto

package com.google.cloud.vision.v1;

public interface AsyncBatchAnnotateFilesRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.cloud.vision.v1.AsyncBatchAnnotateFilesRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. Individual async file annotation requests for this batch.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.vision.v1.AsyncAnnotateFileRequest requests = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  java.util.List<com.google.cloud.vision.v1.AsyncAnnotateFileRequest> getRequestsList();
  /**
   *
   *
   * <pre>
   * Required. Individual async file annotation requests for this batch.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.vision.v1.AsyncAnnotateFileRequest requests = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.cloud.vision.v1.AsyncAnnotateFileRequest getRequests(int index);
  /**
   *
   *
   * <pre>
   * Required. Individual async file annotation requests for this batch.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.vision.v1.AsyncAnnotateFileRequest requests = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  int getRequestsCount();
  /**
   *
   *
   * <pre>
   * Required. Individual async file annotation requests for this batch.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.vision.v1.AsyncAnnotateFileRequest requests = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  java.util.List<? extends com.google.cloud.vision.v1.AsyncAnnotateFileRequestOrBuilder>
      getRequestsOrBuilderList();
  /**
   *
   *
   * <pre>
   * Required. Individual async file annotation requests for this batch.
   * </pre>
   *
   * <code>
   * repeated .google.cloud.vision.v1.AsyncAnnotateFileRequest requests = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.cloud.vision.v1.AsyncAnnotateFileRequestOrBuilder getRequestsOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * Optional. Target project and location to make a call.
   * Format: `projects/{project-id}/locations/{location-id}`.
   * If no parent is specified, a region will be chosen automatically.
   * Supported location-ids:
   *     `us`: USA country only,
   *     `asia`: East asia areas, like Japan, Taiwan,
   *     `eu`: The European Union.
   * Example: `projects/project-A/locations/eu`.
   * </pre>
   *
   * <code>string parent = 4;</code>
   *
   * @return The parent.
   */
  java.lang.String getParent();
  /**
   *
   *
   * <pre>
   * Optional. Target project and location to make a call.
   * Format: `projects/{project-id}/locations/{location-id}`.
   * If no parent is specified, a region will be chosen automatically.
   * Supported location-ids:
   *     `us`: USA country only,
   *     `asia`: East asia areas, like Japan, Taiwan,
   *     `eu`: The European Union.
   * Example: `projects/project-A/locations/eu`.
   * </pre>
   *
   * <code>string parent = 4;</code>
   *
   * @return The bytes for parent.
   */
  com.google.protobuf.ByteString getParentBytes();
}
