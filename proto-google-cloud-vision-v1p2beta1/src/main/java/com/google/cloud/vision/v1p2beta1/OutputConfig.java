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
// source: google/cloud/vision/v1p2beta1/image_annotator.proto

package com.google.cloud.vision.v1p2beta1;

/**
 *
 *
 * <pre>
 * The desired output location and metadata.
 * </pre>
 *
 * Protobuf type {@code google.cloud.vision.v1p2beta1.OutputConfig}
 */
public final class OutputConfig extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.cloud.vision.v1p2beta1.OutputConfig)
    OutputConfigOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use OutputConfig.newBuilder() to construct.
  private OutputConfig(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private OutputConfig() {}

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new OutputConfig();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private OutputConfig(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10:
            {
              com.google.cloud.vision.v1p2beta1.GcsDestination.Builder subBuilder = null;
              if (gcsDestination_ != null) {
                subBuilder = gcsDestination_.toBuilder();
              }
              gcsDestination_ =
                  input.readMessage(
                      com.google.cloud.vision.v1p2beta1.GcsDestination.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(gcsDestination_);
                gcsDestination_ = subBuilder.buildPartial();
              }

              break;
            }
          case 16:
            {
              batchSize_ = input.readInt32();
              break;
            }
          default:
            {
              if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.cloud.vision.v1p2beta1.ImageAnnotatorProto
        .internal_static_google_cloud_vision_v1p2beta1_OutputConfig_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.vision.v1p2beta1.ImageAnnotatorProto
        .internal_static_google_cloud_vision_v1p2beta1_OutputConfig_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.vision.v1p2beta1.OutputConfig.class,
            com.google.cloud.vision.v1p2beta1.OutputConfig.Builder.class);
  }

  public static final int GCS_DESTINATION_FIELD_NUMBER = 1;
  private com.google.cloud.vision.v1p2beta1.GcsDestination gcsDestination_;
  /**
   *
   *
   * <pre>
   * The Google Cloud Storage location to write the output(s) to.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
   *
   * @return Whether the gcsDestination field is set.
   */
  public boolean hasGcsDestination() {
    return gcsDestination_ != null;
  }
  /**
   *
   *
   * <pre>
   * The Google Cloud Storage location to write the output(s) to.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
   *
   * @return The gcsDestination.
   */
  public com.google.cloud.vision.v1p2beta1.GcsDestination getGcsDestination() {
    return gcsDestination_ == null
        ? com.google.cloud.vision.v1p2beta1.GcsDestination.getDefaultInstance()
        : gcsDestination_;
  }
  /**
   *
   *
   * <pre>
   * The Google Cloud Storage location to write the output(s) to.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
   */
  public com.google.cloud.vision.v1p2beta1.GcsDestinationOrBuilder getGcsDestinationOrBuilder() {
    return getGcsDestination();
  }

  public static final int BATCH_SIZE_FIELD_NUMBER = 2;
  private int batchSize_;
  /**
   *
   *
   * <pre>
   * The max number of response protos to put into each output JSON file on GCS.
   * The valid range is [1, 100]. If not specified, the default value is 20.
   * For example, for one pdf file with 100 pages, 100 response protos will
   * be generated. If `batch_size` = 20, then 5 json files each
   * containing 20 response protos will be written under the prefix
   * `gcs_destination`.`uri`.
   * Currently, batch_size only applies to GcsDestination, with potential future
   * support for other output configurations.
   * </pre>
   *
   * <code>int32 batch_size = 2;</code>
   *
   * @return The batchSize.
   */
  public int getBatchSize() {
    return batchSize_;
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (gcsDestination_ != null) {
      output.writeMessage(1, getGcsDestination());
    }
    if (batchSize_ != 0) {
      output.writeInt32(2, batchSize_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (gcsDestination_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getGcsDestination());
    }
    if (batchSize_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(2, batchSize_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.cloud.vision.v1p2beta1.OutputConfig)) {
      return super.equals(obj);
    }
    com.google.cloud.vision.v1p2beta1.OutputConfig other =
        (com.google.cloud.vision.v1p2beta1.OutputConfig) obj;

    if (hasGcsDestination() != other.hasGcsDestination()) return false;
    if (hasGcsDestination()) {
      if (!getGcsDestination().equals(other.getGcsDestination())) return false;
    }
    if (getBatchSize() != other.getBatchSize()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasGcsDestination()) {
      hash = (37 * hash) + GCS_DESTINATION_FIELD_NUMBER;
      hash = (53 * hash) + getGcsDestination().hashCode();
    }
    hash = (37 * hash) + BATCH_SIZE_FIELD_NUMBER;
    hash = (53 * hash) + getBatchSize();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.cloud.vision.v1p2beta1.OutputConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * The desired output location and metadata.
   * </pre>
   *
   * Protobuf type {@code google.cloud.vision.v1p2beta1.OutputConfig}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.cloud.vision.v1p2beta1.OutputConfig)
      com.google.cloud.vision.v1p2beta1.OutputConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.cloud.vision.v1p2beta1.ImageAnnotatorProto
          .internal_static_google_cloud_vision_v1p2beta1_OutputConfig_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.vision.v1p2beta1.ImageAnnotatorProto
          .internal_static_google_cloud_vision_v1p2beta1_OutputConfig_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.vision.v1p2beta1.OutputConfig.class,
              com.google.cloud.vision.v1p2beta1.OutputConfig.Builder.class);
    }

    // Construct using com.google.cloud.vision.v1p2beta1.OutputConfig.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (gcsDestinationBuilder_ == null) {
        gcsDestination_ = null;
      } else {
        gcsDestination_ = null;
        gcsDestinationBuilder_ = null;
      }
      batchSize_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.cloud.vision.v1p2beta1.ImageAnnotatorProto
          .internal_static_google_cloud_vision_v1p2beta1_OutputConfig_descriptor;
    }

    @java.lang.Override
    public com.google.cloud.vision.v1p2beta1.OutputConfig getDefaultInstanceForType() {
      return com.google.cloud.vision.v1p2beta1.OutputConfig.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.cloud.vision.v1p2beta1.OutputConfig build() {
      com.google.cloud.vision.v1p2beta1.OutputConfig result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.cloud.vision.v1p2beta1.OutputConfig buildPartial() {
      com.google.cloud.vision.v1p2beta1.OutputConfig result =
          new com.google.cloud.vision.v1p2beta1.OutputConfig(this);
      if (gcsDestinationBuilder_ == null) {
        result.gcsDestination_ = gcsDestination_;
      } else {
        result.gcsDestination_ = gcsDestinationBuilder_.build();
      }
      result.batchSize_ = batchSize_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.cloud.vision.v1p2beta1.OutputConfig) {
        return mergeFrom((com.google.cloud.vision.v1p2beta1.OutputConfig) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.cloud.vision.v1p2beta1.OutputConfig other) {
      if (other == com.google.cloud.vision.v1p2beta1.OutputConfig.getDefaultInstance()) return this;
      if (other.hasGcsDestination()) {
        mergeGcsDestination(other.getGcsDestination());
      }
      if (other.getBatchSize() != 0) {
        setBatchSize(other.getBatchSize());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.cloud.vision.v1p2beta1.OutputConfig parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.cloud.vision.v1p2beta1.OutputConfig) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.cloud.vision.v1p2beta1.GcsDestination gcsDestination_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.cloud.vision.v1p2beta1.GcsDestination,
            com.google.cloud.vision.v1p2beta1.GcsDestination.Builder,
            com.google.cloud.vision.v1p2beta1.GcsDestinationOrBuilder>
        gcsDestinationBuilder_;
    /**
     *
     *
     * <pre>
     * The Google Cloud Storage location to write the output(s) to.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
     *
     * @return Whether the gcsDestination field is set.
     */
    public boolean hasGcsDestination() {
      return gcsDestinationBuilder_ != null || gcsDestination_ != null;
    }
    /**
     *
     *
     * <pre>
     * The Google Cloud Storage location to write the output(s) to.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
     *
     * @return The gcsDestination.
     */
    public com.google.cloud.vision.v1p2beta1.GcsDestination getGcsDestination() {
      if (gcsDestinationBuilder_ == null) {
        return gcsDestination_ == null
            ? com.google.cloud.vision.v1p2beta1.GcsDestination.getDefaultInstance()
            : gcsDestination_;
      } else {
        return gcsDestinationBuilder_.getMessage();
      }
    }
    /**
     *
     *
     * <pre>
     * The Google Cloud Storage location to write the output(s) to.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
     */
    public Builder setGcsDestination(com.google.cloud.vision.v1p2beta1.GcsDestination value) {
      if (gcsDestinationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        gcsDestination_ = value;
        onChanged();
      } else {
        gcsDestinationBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The Google Cloud Storage location to write the output(s) to.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
     */
    public Builder setGcsDestination(
        com.google.cloud.vision.v1p2beta1.GcsDestination.Builder builderForValue) {
      if (gcsDestinationBuilder_ == null) {
        gcsDestination_ = builderForValue.build();
        onChanged();
      } else {
        gcsDestinationBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The Google Cloud Storage location to write the output(s) to.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
     */
    public Builder mergeGcsDestination(com.google.cloud.vision.v1p2beta1.GcsDestination value) {
      if (gcsDestinationBuilder_ == null) {
        if (gcsDestination_ != null) {
          gcsDestination_ =
              com.google.cloud.vision.v1p2beta1.GcsDestination.newBuilder(gcsDestination_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          gcsDestination_ = value;
        }
        onChanged();
      } else {
        gcsDestinationBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The Google Cloud Storage location to write the output(s) to.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
     */
    public Builder clearGcsDestination() {
      if (gcsDestinationBuilder_ == null) {
        gcsDestination_ = null;
        onChanged();
      } else {
        gcsDestination_ = null;
        gcsDestinationBuilder_ = null;
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The Google Cloud Storage location to write the output(s) to.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
     */
    public com.google.cloud.vision.v1p2beta1.GcsDestination.Builder getGcsDestinationBuilder() {

      onChanged();
      return getGcsDestinationFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * The Google Cloud Storage location to write the output(s) to.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
     */
    public com.google.cloud.vision.v1p2beta1.GcsDestinationOrBuilder getGcsDestinationOrBuilder() {
      if (gcsDestinationBuilder_ != null) {
        return gcsDestinationBuilder_.getMessageOrBuilder();
      } else {
        return gcsDestination_ == null
            ? com.google.cloud.vision.v1p2beta1.GcsDestination.getDefaultInstance()
            : gcsDestination_;
      }
    }
    /**
     *
     *
     * <pre>
     * The Google Cloud Storage location to write the output(s) to.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p2beta1.GcsDestination gcs_destination = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.cloud.vision.v1p2beta1.GcsDestination,
            com.google.cloud.vision.v1p2beta1.GcsDestination.Builder,
            com.google.cloud.vision.v1p2beta1.GcsDestinationOrBuilder>
        getGcsDestinationFieldBuilder() {
      if (gcsDestinationBuilder_ == null) {
        gcsDestinationBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.cloud.vision.v1p2beta1.GcsDestination,
                com.google.cloud.vision.v1p2beta1.GcsDestination.Builder,
                com.google.cloud.vision.v1p2beta1.GcsDestinationOrBuilder>(
                getGcsDestination(), getParentForChildren(), isClean());
        gcsDestination_ = null;
      }
      return gcsDestinationBuilder_;
    }

    private int batchSize_;
    /**
     *
     *
     * <pre>
     * The max number of response protos to put into each output JSON file on GCS.
     * The valid range is [1, 100]. If not specified, the default value is 20.
     * For example, for one pdf file with 100 pages, 100 response protos will
     * be generated. If `batch_size` = 20, then 5 json files each
     * containing 20 response protos will be written under the prefix
     * `gcs_destination`.`uri`.
     * Currently, batch_size only applies to GcsDestination, with potential future
     * support for other output configurations.
     * </pre>
     *
     * <code>int32 batch_size = 2;</code>
     *
     * @return The batchSize.
     */
    public int getBatchSize() {
      return batchSize_;
    }
    /**
     *
     *
     * <pre>
     * The max number of response protos to put into each output JSON file on GCS.
     * The valid range is [1, 100]. If not specified, the default value is 20.
     * For example, for one pdf file with 100 pages, 100 response protos will
     * be generated. If `batch_size` = 20, then 5 json files each
     * containing 20 response protos will be written under the prefix
     * `gcs_destination`.`uri`.
     * Currently, batch_size only applies to GcsDestination, with potential future
     * support for other output configurations.
     * </pre>
     *
     * <code>int32 batch_size = 2;</code>
     *
     * @param value The batchSize to set.
     * @return This builder for chaining.
     */
    public Builder setBatchSize(int value) {

      batchSize_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The max number of response protos to put into each output JSON file on GCS.
     * The valid range is [1, 100]. If not specified, the default value is 20.
     * For example, for one pdf file with 100 pages, 100 response protos will
     * be generated. If `batch_size` = 20, then 5 json files each
     * containing 20 response protos will be written under the prefix
     * `gcs_destination`.`uri`.
     * Currently, batch_size only applies to GcsDestination, with potential future
     * support for other output configurations.
     * </pre>
     *
     * <code>int32 batch_size = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearBatchSize() {

      batchSize_ = 0;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.cloud.vision.v1p2beta1.OutputConfig)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.vision.v1p2beta1.OutputConfig)
  private static final com.google.cloud.vision.v1p2beta1.OutputConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.cloud.vision.v1p2beta1.OutputConfig();
  }

  public static com.google.cloud.vision.v1p2beta1.OutputConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OutputConfig> PARSER =
      new com.google.protobuf.AbstractParser<OutputConfig>() {
        @java.lang.Override
        public OutputConfig parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new OutputConfig(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<OutputConfig> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OutputConfig> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.cloud.vision.v1p2beta1.OutputConfig getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
