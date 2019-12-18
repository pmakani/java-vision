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
// source: google/cloud/vision/v1p4beta1/product_search_service.proto

package com.google.cloud.vision.v1p4beta1;

/**
 *
 *
 * <pre>
 * Request message for the `PurgeProducts` method.
 * </pre>
 *
 * Protobuf type {@code google.cloud.vision.v1p4beta1.PurgeProductsRequest}
 */
public final class PurgeProductsRequest extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.cloud.vision.v1p4beta1.PurgeProductsRequest)
    PurgeProductsRequestOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use PurgeProductsRequest.newBuilder() to construct.
  private PurgeProductsRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private PurgeProductsRequest() {
    parent_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new PurgeProductsRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private PurgeProductsRequest(
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
              java.lang.String s = input.readStringRequireUtf8();

              parent_ = s;
              break;
            }
          case 18:
            {
              com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.Builder subBuilder = null;
              if (targetCase_ == 2) {
                subBuilder =
                    ((com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig) target_).toBuilder();
              }
              target_ =
                  input.readMessage(
                      com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.parser(),
                      extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(
                    (com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig) target_);
                target_ = subBuilder.buildPartial();
              }
              targetCase_ = 2;
              break;
            }
          case 24:
            {
              targetCase_ = 3;
              target_ = input.readBool();
              break;
            }
          case 32:
            {
              force_ = input.readBool();
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
    return com.google.cloud.vision.v1p4beta1.ProductSearchServiceProto
        .internal_static_google_cloud_vision_v1p4beta1_PurgeProductsRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.cloud.vision.v1p4beta1.ProductSearchServiceProto
        .internal_static_google_cloud_vision_v1p4beta1_PurgeProductsRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.cloud.vision.v1p4beta1.PurgeProductsRequest.class,
            com.google.cloud.vision.v1p4beta1.PurgeProductsRequest.Builder.class);
  }

  private int targetCase_ = 0;
  private java.lang.Object target_;

  public enum TargetCase
      implements
          com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    PRODUCT_SET_PURGE_CONFIG(2),
    DELETE_ORPHAN_PRODUCTS(3),
    TARGET_NOT_SET(0);
    private final int value;

    private TargetCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static TargetCase valueOf(int value) {
      return forNumber(value);
    }

    public static TargetCase forNumber(int value) {
      switch (value) {
        case 2:
          return PRODUCT_SET_PURGE_CONFIG;
        case 3:
          return DELETE_ORPHAN_PRODUCTS;
        case 0:
          return TARGET_NOT_SET;
        default:
          return null;
      }
    }

    public int getNumber() {
      return this.value;
    }
  };

  public TargetCase getTargetCase() {
    return TargetCase.forNumber(targetCase_);
  }

  public static final int PRODUCT_SET_PURGE_CONFIG_FIELD_NUMBER = 2;
  /**
   *
   *
   * <pre>
   * Specify which ProductSet contains the Products to be deleted.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;</code>
   *
   * @return Whether the productSetPurgeConfig field is set.
   */
  public boolean hasProductSetPurgeConfig() {
    return targetCase_ == 2;
  }
  /**
   *
   *
   * <pre>
   * Specify which ProductSet contains the Products to be deleted.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;</code>
   *
   * @return The productSetPurgeConfig.
   */
  public com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig getProductSetPurgeConfig() {
    if (targetCase_ == 2) {
      return (com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig) target_;
    }
    return com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.getDefaultInstance();
  }
  /**
   *
   *
   * <pre>
   * Specify which ProductSet contains the Products to be deleted.
   * </pre>
   *
   * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;</code>
   */
  public com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfigOrBuilder
      getProductSetPurgeConfigOrBuilder() {
    if (targetCase_ == 2) {
      return (com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig) target_;
    }
    return com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.getDefaultInstance();
  }

  public static final int DELETE_ORPHAN_PRODUCTS_FIELD_NUMBER = 3;
  /**
   *
   *
   * <pre>
   * If delete_orphan_products is true, all Products that are not in any
   * ProductSet will be deleted.
   * </pre>
   *
   * <code>bool delete_orphan_products = 3;</code>
   *
   * @return The deleteOrphanProducts.
   */
  public boolean getDeleteOrphanProducts() {
    if (targetCase_ == 3) {
      return (java.lang.Boolean) target_;
    }
    return false;
  }

  public static final int PARENT_FIELD_NUMBER = 1;
  private volatile java.lang.Object parent_;
  /**
   *
   *
   * <pre>
   * Required. The project and location in which the Products should be deleted.
   * Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The parent.
   */
  public java.lang.String getParent() {
    java.lang.Object ref = parent_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      parent_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * Required. The project and location in which the Products should be deleted.
   * Format is `projects/PROJECT_ID/locations/LOC_ID`.
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for parent.
   */
  public com.google.protobuf.ByteString getParentBytes() {
    java.lang.Object ref = parent_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      parent_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FORCE_FIELD_NUMBER = 4;
  private boolean force_;
  /**
   *
   *
   * <pre>
   * The default value is false. Override this value to true to actually perform
   * the purge.
   * </pre>
   *
   * <code>bool force = 4;</code>
   *
   * @return The force.
   */
  public boolean getForce() {
    return force_;
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
    if (!getParentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, parent_);
    }
    if (targetCase_ == 2) {
      output.writeMessage(2, (com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig) target_);
    }
    if (targetCase_ == 3) {
      output.writeBool(3, (boolean) ((java.lang.Boolean) target_));
    }
    if (force_ != false) {
      output.writeBool(4, force_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getParentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, parent_);
    }
    if (targetCase_ == 2) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              2, (com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig) target_);
    }
    if (targetCase_ == 3) {
      size +=
          com.google.protobuf.CodedOutputStream.computeBoolSize(
              3, (boolean) ((java.lang.Boolean) target_));
    }
    if (force_ != false) {
      size += com.google.protobuf.CodedOutputStream.computeBoolSize(4, force_);
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
    if (!(obj instanceof com.google.cloud.vision.v1p4beta1.PurgeProductsRequest)) {
      return super.equals(obj);
    }
    com.google.cloud.vision.v1p4beta1.PurgeProductsRequest other =
        (com.google.cloud.vision.v1p4beta1.PurgeProductsRequest) obj;

    if (!getParent().equals(other.getParent())) return false;
    if (getForce() != other.getForce()) return false;
    if (!getTargetCase().equals(other.getTargetCase())) return false;
    switch (targetCase_) {
      case 2:
        if (!getProductSetPurgeConfig().equals(other.getProductSetPurgeConfig())) return false;
        break;
      case 3:
        if (getDeleteOrphanProducts() != other.getDeleteOrphanProducts()) return false;
        break;
      case 0:
      default:
    }
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
    hash = (37 * hash) + PARENT_FIELD_NUMBER;
    hash = (53 * hash) + getParent().hashCode();
    hash = (37 * hash) + FORCE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getForce());
    switch (targetCase_) {
      case 2:
        hash = (37 * hash) + PRODUCT_SET_PURGE_CONFIG_FIELD_NUMBER;
        hash = (53 * hash) + getProductSetPurgeConfig().hashCode();
        break;
      case 3:
        hash = (37 * hash) + DELETE_ORPHAN_PRODUCTS_FIELD_NUMBER;
        hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(getDeleteOrphanProducts());
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parseFrom(
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

  public static Builder newBuilder(
      com.google.cloud.vision.v1p4beta1.PurgeProductsRequest prototype) {
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
   * Request message for the `PurgeProducts` method.
   * </pre>
   *
   * Protobuf type {@code google.cloud.vision.v1p4beta1.PurgeProductsRequest}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.cloud.vision.v1p4beta1.PurgeProductsRequest)
      com.google.cloud.vision.v1p4beta1.PurgeProductsRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.cloud.vision.v1p4beta1.ProductSearchServiceProto
          .internal_static_google_cloud_vision_v1p4beta1_PurgeProductsRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.cloud.vision.v1p4beta1.ProductSearchServiceProto
          .internal_static_google_cloud_vision_v1p4beta1_PurgeProductsRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.cloud.vision.v1p4beta1.PurgeProductsRequest.class,
              com.google.cloud.vision.v1p4beta1.PurgeProductsRequest.Builder.class);
    }

    // Construct using com.google.cloud.vision.v1p4beta1.PurgeProductsRequest.newBuilder()
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
      parent_ = "";

      force_ = false;

      targetCase_ = 0;
      target_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.cloud.vision.v1p4beta1.ProductSearchServiceProto
          .internal_static_google_cloud_vision_v1p4beta1_PurgeProductsRequest_descriptor;
    }

    @java.lang.Override
    public com.google.cloud.vision.v1p4beta1.PurgeProductsRequest getDefaultInstanceForType() {
      return com.google.cloud.vision.v1p4beta1.PurgeProductsRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.cloud.vision.v1p4beta1.PurgeProductsRequest build() {
      com.google.cloud.vision.v1p4beta1.PurgeProductsRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.cloud.vision.v1p4beta1.PurgeProductsRequest buildPartial() {
      com.google.cloud.vision.v1p4beta1.PurgeProductsRequest result =
          new com.google.cloud.vision.v1p4beta1.PurgeProductsRequest(this);
      if (targetCase_ == 2) {
        if (productSetPurgeConfigBuilder_ == null) {
          result.target_ = target_;
        } else {
          result.target_ = productSetPurgeConfigBuilder_.build();
        }
      }
      if (targetCase_ == 3) {
        result.target_ = target_;
      }
      result.parent_ = parent_;
      result.force_ = force_;
      result.targetCase_ = targetCase_;
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
      if (other instanceof com.google.cloud.vision.v1p4beta1.PurgeProductsRequest) {
        return mergeFrom((com.google.cloud.vision.v1p4beta1.PurgeProductsRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.cloud.vision.v1p4beta1.PurgeProductsRequest other) {
      if (other == com.google.cloud.vision.v1p4beta1.PurgeProductsRequest.getDefaultInstance())
        return this;
      if (!other.getParent().isEmpty()) {
        parent_ = other.parent_;
        onChanged();
      }
      if (other.getForce() != false) {
        setForce(other.getForce());
      }
      switch (other.getTargetCase()) {
        case PRODUCT_SET_PURGE_CONFIG:
          {
            mergeProductSetPurgeConfig(other.getProductSetPurgeConfig());
            break;
          }
        case DELETE_ORPHAN_PRODUCTS:
          {
            setDeleteOrphanProducts(other.getDeleteOrphanProducts());
            break;
          }
        case TARGET_NOT_SET:
          {
            break;
          }
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
      com.google.cloud.vision.v1p4beta1.PurgeProductsRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage =
            (com.google.cloud.vision.v1p4beta1.PurgeProductsRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int targetCase_ = 0;
    private java.lang.Object target_;

    public TargetCase getTargetCase() {
      return TargetCase.forNumber(targetCase_);
    }

    public Builder clearTarget() {
      targetCase_ = 0;
      target_ = null;
      onChanged();
      return this;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig,
            com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.Builder,
            com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfigOrBuilder>
        productSetPurgeConfigBuilder_;
    /**
     *
     *
     * <pre>
     * Specify which ProductSet contains the Products to be deleted.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;
     * </code>
     *
     * @return Whether the productSetPurgeConfig field is set.
     */
    public boolean hasProductSetPurgeConfig() {
      return targetCase_ == 2;
    }
    /**
     *
     *
     * <pre>
     * Specify which ProductSet contains the Products to be deleted.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;
     * </code>
     *
     * @return The productSetPurgeConfig.
     */
    public com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig getProductSetPurgeConfig() {
      if (productSetPurgeConfigBuilder_ == null) {
        if (targetCase_ == 2) {
          return (com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig) target_;
        }
        return com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.getDefaultInstance();
      } else {
        if (targetCase_ == 2) {
          return productSetPurgeConfigBuilder_.getMessage();
        }
        return com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.getDefaultInstance();
      }
    }
    /**
     *
     *
     * <pre>
     * Specify which ProductSet contains the Products to be deleted.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;
     * </code>
     */
    public Builder setProductSetPurgeConfig(
        com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig value) {
      if (productSetPurgeConfigBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        target_ = value;
        onChanged();
      } else {
        productSetPurgeConfigBuilder_.setMessage(value);
      }
      targetCase_ = 2;
      return this;
    }
    /**
     *
     *
     * <pre>
     * Specify which ProductSet contains the Products to be deleted.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;
     * </code>
     */
    public Builder setProductSetPurgeConfig(
        com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.Builder builderForValue) {
      if (productSetPurgeConfigBuilder_ == null) {
        target_ = builderForValue.build();
        onChanged();
      } else {
        productSetPurgeConfigBuilder_.setMessage(builderForValue.build());
      }
      targetCase_ = 2;
      return this;
    }
    /**
     *
     *
     * <pre>
     * Specify which ProductSet contains the Products to be deleted.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;
     * </code>
     */
    public Builder mergeProductSetPurgeConfig(
        com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig value) {
      if (productSetPurgeConfigBuilder_ == null) {
        if (targetCase_ == 2
            && target_
                != com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.getDefaultInstance()) {
          target_ =
              com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.newBuilder(
                      (com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig) target_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          target_ = value;
        }
        onChanged();
      } else {
        if (targetCase_ == 2) {
          productSetPurgeConfigBuilder_.mergeFrom(value);
        }
        productSetPurgeConfigBuilder_.setMessage(value);
      }
      targetCase_ = 2;
      return this;
    }
    /**
     *
     *
     * <pre>
     * Specify which ProductSet contains the Products to be deleted.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;
     * </code>
     */
    public Builder clearProductSetPurgeConfig() {
      if (productSetPurgeConfigBuilder_ == null) {
        if (targetCase_ == 2) {
          targetCase_ = 0;
          target_ = null;
          onChanged();
        }
      } else {
        if (targetCase_ == 2) {
          targetCase_ = 0;
          target_ = null;
        }
        productSetPurgeConfigBuilder_.clear();
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Specify which ProductSet contains the Products to be deleted.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;
     * </code>
     */
    public com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.Builder
        getProductSetPurgeConfigBuilder() {
      return getProductSetPurgeConfigFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * Specify which ProductSet contains the Products to be deleted.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;
     * </code>
     */
    public com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfigOrBuilder
        getProductSetPurgeConfigOrBuilder() {
      if ((targetCase_ == 2) && (productSetPurgeConfigBuilder_ != null)) {
        return productSetPurgeConfigBuilder_.getMessageOrBuilder();
      } else {
        if (targetCase_ == 2) {
          return (com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig) target_;
        }
        return com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.getDefaultInstance();
      }
    }
    /**
     *
     *
     * <pre>
     * Specify which ProductSet contains the Products to be deleted.
     * </pre>
     *
     * <code>.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig product_set_purge_config = 2;
     * </code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig,
            com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.Builder,
            com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfigOrBuilder>
        getProductSetPurgeConfigFieldBuilder() {
      if (productSetPurgeConfigBuilder_ == null) {
        if (!(targetCase_ == 2)) {
          target_ = com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.getDefaultInstance();
        }
        productSetPurgeConfigBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig,
                com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig.Builder,
                com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfigOrBuilder>(
                (com.google.cloud.vision.v1p4beta1.ProductSetPurgeConfig) target_,
                getParentForChildren(),
                isClean());
        target_ = null;
      }
      targetCase_ = 2;
      onChanged();
      ;
      return productSetPurgeConfigBuilder_;
    }

    /**
     *
     *
     * <pre>
     * If delete_orphan_products is true, all Products that are not in any
     * ProductSet will be deleted.
     * </pre>
     *
     * <code>bool delete_orphan_products = 3;</code>
     *
     * @return The deleteOrphanProducts.
     */
    public boolean getDeleteOrphanProducts() {
      if (targetCase_ == 3) {
        return (java.lang.Boolean) target_;
      }
      return false;
    }
    /**
     *
     *
     * <pre>
     * If delete_orphan_products is true, all Products that are not in any
     * ProductSet will be deleted.
     * </pre>
     *
     * <code>bool delete_orphan_products = 3;</code>
     *
     * @param value The deleteOrphanProducts to set.
     * @return This builder for chaining.
     */
    public Builder setDeleteOrphanProducts(boolean value) {
      targetCase_ = 3;
      target_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * If delete_orphan_products is true, all Products that are not in any
     * ProductSet will be deleted.
     * </pre>
     *
     * <code>bool delete_orphan_products = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDeleteOrphanProducts() {
      if (targetCase_ == 3) {
        targetCase_ = 0;
        target_ = null;
        onChanged();
      }
      return this;
    }

    private java.lang.Object parent_ = "";
    /**
     *
     *
     * <pre>
     * Required. The project and location in which the Products should be deleted.
     * Format is `projects/PROJECT_ID/locations/LOC_ID`.
     * </pre>
     *
     * <code>
     * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
     * </code>
     *
     * @return The parent.
     */
    public java.lang.String getParent() {
      java.lang.Object ref = parent_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        parent_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Required. The project and location in which the Products should be deleted.
     * Format is `projects/PROJECT_ID/locations/LOC_ID`.
     * </pre>
     *
     * <code>
     * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
     * </code>
     *
     * @return The bytes for parent.
     */
    public com.google.protobuf.ByteString getParentBytes() {
      java.lang.Object ref = parent_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        parent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * Required. The project and location in which the Products should be deleted.
     * Format is `projects/PROJECT_ID/locations/LOC_ID`.
     * </pre>
     *
     * <code>
     * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
     * </code>
     *
     * @param value The parent to set.
     * @return This builder for chaining.
     */
    public Builder setParent(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      parent_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Required. The project and location in which the Products should be deleted.
     * Format is `projects/PROJECT_ID/locations/LOC_ID`.
     * </pre>
     *
     * <code>
     * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
     * </code>
     *
     * @return This builder for chaining.
     */
    public Builder clearParent() {

      parent_ = getDefaultInstance().getParent();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Required. The project and location in which the Products should be deleted.
     * Format is `projects/PROJECT_ID/locations/LOC_ID`.
     * </pre>
     *
     * <code>
     * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
     * </code>
     *
     * @param value The bytes for parent to set.
     * @return This builder for chaining.
     */
    public Builder setParentBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      parent_ = value;
      onChanged();
      return this;
    }

    private boolean force_;
    /**
     *
     *
     * <pre>
     * The default value is false. Override this value to true to actually perform
     * the purge.
     * </pre>
     *
     * <code>bool force = 4;</code>
     *
     * @return The force.
     */
    public boolean getForce() {
      return force_;
    }
    /**
     *
     *
     * <pre>
     * The default value is false. Override this value to true to actually perform
     * the purge.
     * </pre>
     *
     * <code>bool force = 4;</code>
     *
     * @param value The force to set.
     * @return This builder for chaining.
     */
    public Builder setForce(boolean value) {

      force_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The default value is false. Override this value to true to actually perform
     * the purge.
     * </pre>
     *
     * <code>bool force = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearForce() {

      force_ = false;
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

    // @@protoc_insertion_point(builder_scope:google.cloud.vision.v1p4beta1.PurgeProductsRequest)
  }

  // @@protoc_insertion_point(class_scope:google.cloud.vision.v1p4beta1.PurgeProductsRequest)
  private static final com.google.cloud.vision.v1p4beta1.PurgeProductsRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.cloud.vision.v1p4beta1.PurgeProductsRequest();
  }

  public static com.google.cloud.vision.v1p4beta1.PurgeProductsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PurgeProductsRequest> PARSER =
      new com.google.protobuf.AbstractParser<PurgeProductsRequest>() {
        @java.lang.Override
        public PurgeProductsRequest parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new PurgeProductsRequest(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<PurgeProductsRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PurgeProductsRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.cloud.vision.v1p4beta1.PurgeProductsRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
