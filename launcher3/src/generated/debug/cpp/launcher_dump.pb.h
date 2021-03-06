// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: launcher_dump.proto

#ifndef PROTOBUF_launcher_5fdump_2eproto__INCLUDED
#define PROTOBUF_launcher_5fdump_2eproto__INCLUDED

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 3001000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 3001000 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/metadata.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>
#include <google/protobuf/extension_set.h>
#include <google/protobuf/generated_enum_reflection.h>
#include <google/protobuf/unknown_field_set.h>
// @@protoc_insertion_point(includes)

namespace model {

// Internal implementation detail -- do not call these.
void protobuf_AddDesc_launcher_5fdump_2eproto();
void protobuf_InitDefaults_launcher_5fdump_2eproto();
void protobuf_AssignDesc_launcher_5fdump_2eproto();
void protobuf_ShutdownFile_launcher_5fdump_2eproto();

class DumpTarget;
class LauncherImpression;

enum DumpTarget_Type {
  DumpTarget_Type_NONE = 0,
  DumpTarget_Type_ITEM = 1,
  DumpTarget_Type_CONTAINER = 2
};
bool DumpTarget_Type_IsValid(int value);
const DumpTarget_Type DumpTarget_Type_Type_MIN = DumpTarget_Type_NONE;
const DumpTarget_Type DumpTarget_Type_Type_MAX = DumpTarget_Type_CONTAINER;
const int DumpTarget_Type_Type_ARRAYSIZE = DumpTarget_Type_Type_MAX + 1;

const ::google::protobuf::EnumDescriptor* DumpTarget_Type_descriptor();
inline const ::std::string& DumpTarget_Type_Name(DumpTarget_Type value) {
  return ::google::protobuf::internal::NameOfEnum(
    DumpTarget_Type_descriptor(), value);
}
inline bool DumpTarget_Type_Parse(
    const ::std::string& name, DumpTarget_Type* value) {
  return ::google::protobuf::internal::ParseNamedEnum<DumpTarget_Type>(
    DumpTarget_Type_descriptor(), name, value);
}
enum ItemType {
  UNKNOWN_ITEMTYPE = 0,
  APP_ICON = 1,
  WIDGET = 2,
  SHORTCUT = 3
};
bool ItemType_IsValid(int value);
const ItemType ItemType_MIN = UNKNOWN_ITEMTYPE;
const ItemType ItemType_MAX = SHORTCUT;
const int ItemType_ARRAYSIZE = ItemType_MAX + 1;

const ::google::protobuf::EnumDescriptor* ItemType_descriptor();
inline const ::std::string& ItemType_Name(ItemType value) {
  return ::google::protobuf::internal::NameOfEnum(
    ItemType_descriptor(), value);
}
inline bool ItemType_Parse(
    const ::std::string& name, ItemType* value) {
  return ::google::protobuf::internal::ParseNamedEnum<ItemType>(
    ItemType_descriptor(), name, value);
}
enum ContainerType {
  UNKNOWN_CONTAINERTYPE = 0,
  WORKSPACE = 1,
  HOTSEAT = 2,
  FOLDER = 3
};
bool ContainerType_IsValid(int value);
const ContainerType ContainerType_MIN = UNKNOWN_CONTAINERTYPE;
const ContainerType ContainerType_MAX = FOLDER;
const int ContainerType_ARRAYSIZE = ContainerType_MAX + 1;

const ::google::protobuf::EnumDescriptor* ContainerType_descriptor();
inline const ::std::string& ContainerType_Name(ContainerType value) {
  return ::google::protobuf::internal::NameOfEnum(
    ContainerType_descriptor(), value);
}
inline bool ContainerType_Parse(
    const ::std::string& name, ContainerType* value) {
  return ::google::protobuf::internal::ParseNamedEnum<ContainerType>(
    ContainerType_descriptor(), name, value);
}
enum UserType {
  DEFAULT = 0,
  WORK = 1
};
bool UserType_IsValid(int value);
const UserType UserType_MIN = DEFAULT;
const UserType UserType_MAX = WORK;
const int UserType_ARRAYSIZE = UserType_MAX + 1;

const ::google::protobuf::EnumDescriptor* UserType_descriptor();
inline const ::std::string& UserType_Name(UserType value) {
  return ::google::protobuf::internal::NameOfEnum(
    UserType_descriptor(), value);
}
inline bool UserType_Parse(
    const ::std::string& name, UserType* value) {
  return ::google::protobuf::internal::ParseNamedEnum<UserType>(
    UserType_descriptor(), name, value);
}
// ===================================================================

class DumpTarget : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:model.DumpTarget) */ {
 public:
  DumpTarget();
  virtual ~DumpTarget();

  DumpTarget(const DumpTarget& from);

  inline DumpTarget& operator=(const DumpTarget& from) {
    CopyFrom(from);
    return *this;
  }

  inline const ::google::protobuf::UnknownFieldSet& unknown_fields() const {
    return _internal_metadata_.unknown_fields();
  }

  inline ::google::protobuf::UnknownFieldSet* mutable_unknown_fields() {
    return _internal_metadata_.mutable_unknown_fields();
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const DumpTarget& default_instance();

  static const DumpTarget* internal_default_instance();

  void Swap(DumpTarget* other);

  // implements Message ----------------------------------------------

  inline DumpTarget* New() const { return New(NULL); }

  DumpTarget* New(::google::protobuf::Arena* arena) const;
  void CopyFrom(const ::google::protobuf::Message& from);
  void MergeFrom(const ::google::protobuf::Message& from);
  void CopyFrom(const DumpTarget& from);
  void MergeFrom(const DumpTarget& from);
  void Clear();
  bool IsInitialized() const;

  size_t ByteSizeLong() const;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input);
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* output) const;
  ::google::protobuf::uint8* SerializeWithCachedSizesToArray(::google::protobuf::uint8* output) const {
    return InternalSerializeWithCachedSizesToArray(false, output);
  }
  int GetCachedSize() const { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const;
  void InternalSwap(DumpTarget* other);
  void UnsafeMergeFrom(const DumpTarget& from);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return _internal_metadata_.arena();
  }
  inline void* MaybeArenaPtr() const {
    return _internal_metadata_.raw_arena_ptr();
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const;

  // nested types ----------------------------------------------------

  typedef DumpTarget_Type Type;
  static const Type NONE =
    DumpTarget_Type_NONE;
  static const Type ITEM =
    DumpTarget_Type_ITEM;
  static const Type CONTAINER =
    DumpTarget_Type_CONTAINER;
  static inline bool Type_IsValid(int value) {
    return DumpTarget_Type_IsValid(value);
  }
  static const Type Type_MIN =
    DumpTarget_Type_Type_MIN;
  static const Type Type_MAX =
    DumpTarget_Type_Type_MAX;
  static const int Type_ARRAYSIZE =
    DumpTarget_Type_Type_ARRAYSIZE;
  static inline const ::google::protobuf::EnumDescriptor*
  Type_descriptor() {
    return DumpTarget_Type_descriptor();
  }
  static inline const ::std::string& Type_Name(Type value) {
    return DumpTarget_Type_Name(value);
  }
  static inline bool Type_Parse(const ::std::string& name,
      Type* value) {
    return DumpTarget_Type_Parse(name, value);
  }

  // accessors -------------------------------------------------------

  // optional .model.DumpTarget.Type type = 1;
  bool has_type() const;
  void clear_type();
  static const int kTypeFieldNumber = 1;
  ::model::DumpTarget_Type type() const;
  void set_type(::model::DumpTarget_Type value);

  // optional int32 page_id = 2;
  bool has_page_id() const;
  void clear_page_id();
  static const int kPageIdFieldNumber = 2;
  ::google::protobuf::int32 page_id() const;
  void set_page_id(::google::protobuf::int32 value);

  // optional int32 grid_x = 3;
  bool has_grid_x() const;
  void clear_grid_x();
  static const int kGridXFieldNumber = 3;
  ::google::protobuf::int32 grid_x() const;
  void set_grid_x(::google::protobuf::int32 value);

  // optional int32 grid_y = 4;
  bool has_grid_y() const;
  void clear_grid_y();
  static const int kGridYFieldNumber = 4;
  ::google::protobuf::int32 grid_y() const;
  void set_grid_y(::google::protobuf::int32 value);

  // optional .model.ContainerType container_type = 5;
  bool has_container_type() const;
  void clear_container_type();
  static const int kContainerTypeFieldNumber = 5;
  ::model::ContainerType container_type() const;
  void set_container_type(::model::ContainerType value);

  // optional .model.ItemType item_type = 6;
  bool has_item_type() const;
  void clear_item_type();
  static const int kItemTypeFieldNumber = 6;
  ::model::ItemType item_type() const;
  void set_item_type(::model::ItemType value);

  // optional string package_name = 7;
  bool has_package_name() const;
  void clear_package_name();
  static const int kPackageNameFieldNumber = 7;
  const ::std::string& package_name() const;
  void set_package_name(const ::std::string& value);
  void set_package_name(const char* value);
  void set_package_name(const char* value, size_t size);
  ::std::string* mutable_package_name();
  ::std::string* release_package_name();
  void set_allocated_package_name(::std::string* package_name);

  // optional string component = 8;
  bool has_component() const;
  void clear_component();
  static const int kComponentFieldNumber = 8;
  const ::std::string& component() const;
  void set_component(const ::std::string& value);
  void set_component(const char* value);
  void set_component(const char* value, size_t size);
  ::std::string* mutable_component();
  ::std::string* release_component();
  void set_allocated_component(::std::string* component);

  // optional string item_id = 9;
  bool has_item_id() const;
  void clear_item_id();
  static const int kItemIdFieldNumber = 9;
  const ::std::string& item_id() const;
  void set_item_id(const ::std::string& value);
  void set_item_id(const char* value);
  void set_item_id(const char* value, size_t size);
  ::std::string* mutable_item_id();
  ::std::string* release_item_id();
  void set_allocated_item_id(::std::string* item_id);

  // optional int32 span_x = 10 [default = 1];
  bool has_span_x() const;
  void clear_span_x();
  static const int kSpanXFieldNumber = 10;
  ::google::protobuf::int32 span_x() const;
  void set_span_x(::google::protobuf::int32 value);

  // optional int32 span_y = 11 [default = 1];
  bool has_span_y() const;
  void clear_span_y();
  static const int kSpanYFieldNumber = 11;
  ::google::protobuf::int32 span_y() const;
  void set_span_y(::google::protobuf::int32 value);

  // optional .model.UserType user_type = 12;
  bool has_user_type() const;
  void clear_user_type();
  static const int kUserTypeFieldNumber = 12;
  ::model::UserType user_type() const;
  void set_user_type(::model::UserType value);

  // @@protoc_insertion_point(class_scope:model.DumpTarget)
 private:
  inline void set_has_type();
  inline void clear_has_type();
  inline void set_has_page_id();
  inline void clear_has_page_id();
  inline void set_has_grid_x();
  inline void clear_has_grid_x();
  inline void set_has_grid_y();
  inline void clear_has_grid_y();
  inline void set_has_container_type();
  inline void clear_has_container_type();
  inline void set_has_item_type();
  inline void clear_has_item_type();
  inline void set_has_package_name();
  inline void clear_has_package_name();
  inline void set_has_component();
  inline void clear_has_component();
  inline void set_has_item_id();
  inline void clear_has_item_id();
  inline void set_has_span_x();
  inline void clear_has_span_x();
  inline void set_has_span_y();
  inline void clear_has_span_y();
  inline void set_has_user_type();
  inline void clear_has_user_type();

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  ::google::protobuf::internal::HasBits<1> _has_bits_;
  mutable int _cached_size_;
  ::google::protobuf::internal::ArenaStringPtr package_name_;
  ::google::protobuf::internal::ArenaStringPtr component_;
  ::google::protobuf::internal::ArenaStringPtr item_id_;
  int type_;
  ::google::protobuf::int32 page_id_;
  ::google::protobuf::int32 grid_x_;
  ::google::protobuf::int32 grid_y_;
  int container_type_;
  int item_type_;
  int user_type_;
  ::google::protobuf::int32 span_x_;
  ::google::protobuf::int32 span_y_;
  friend void  protobuf_InitDefaults_launcher_5fdump_2eproto_impl();
  friend void  protobuf_AddDesc_launcher_5fdump_2eproto_impl();
  friend void protobuf_AssignDesc_launcher_5fdump_2eproto();
  friend void protobuf_ShutdownFile_launcher_5fdump_2eproto();

  void InitAsDefaultInstance();
};
extern ::google::protobuf::internal::ExplicitlyConstructed<DumpTarget> DumpTarget_default_instance_;

// -------------------------------------------------------------------

class LauncherImpression : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:model.LauncherImpression) */ {
 public:
  LauncherImpression();
  virtual ~LauncherImpression();

  LauncherImpression(const LauncherImpression& from);

  inline LauncherImpression& operator=(const LauncherImpression& from) {
    CopyFrom(from);
    return *this;
  }

  inline const ::google::protobuf::UnknownFieldSet& unknown_fields() const {
    return _internal_metadata_.unknown_fields();
  }

  inline ::google::protobuf::UnknownFieldSet* mutable_unknown_fields() {
    return _internal_metadata_.mutable_unknown_fields();
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const LauncherImpression& default_instance();

  static const LauncherImpression* internal_default_instance();

  void Swap(LauncherImpression* other);

  // implements Message ----------------------------------------------

  inline LauncherImpression* New() const { return New(NULL); }

  LauncherImpression* New(::google::protobuf::Arena* arena) const;
  void CopyFrom(const ::google::protobuf::Message& from);
  void MergeFrom(const ::google::protobuf::Message& from);
  void CopyFrom(const LauncherImpression& from);
  void MergeFrom(const LauncherImpression& from);
  void Clear();
  bool IsInitialized() const;

  size_t ByteSizeLong() const;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input);
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* output) const;
  ::google::protobuf::uint8* SerializeWithCachedSizesToArray(::google::protobuf::uint8* output) const {
    return InternalSerializeWithCachedSizesToArray(false, output);
  }
  int GetCachedSize() const { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const;
  void InternalSwap(LauncherImpression* other);
  void UnsafeMergeFrom(const LauncherImpression& from);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return _internal_metadata_.arena();
  }
  inline void* MaybeArenaPtr() const {
    return _internal_metadata_.raw_arena_ptr();
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // repeated .model.DumpTarget targets = 1;
  int targets_size() const;
  void clear_targets();
  static const int kTargetsFieldNumber = 1;
  const ::model::DumpTarget& targets(int index) const;
  ::model::DumpTarget* mutable_targets(int index);
  ::model::DumpTarget* add_targets();
  ::google::protobuf::RepeatedPtrField< ::model::DumpTarget >*
      mutable_targets();
  const ::google::protobuf::RepeatedPtrField< ::model::DumpTarget >&
      targets() const;

  // @@protoc_insertion_point(class_scope:model.LauncherImpression)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  ::google::protobuf::internal::HasBits<1> _has_bits_;
  mutable int _cached_size_;
  ::google::protobuf::RepeatedPtrField< ::model::DumpTarget > targets_;
  friend void  protobuf_InitDefaults_launcher_5fdump_2eproto_impl();
  friend void  protobuf_AddDesc_launcher_5fdump_2eproto_impl();
  friend void protobuf_AssignDesc_launcher_5fdump_2eproto();
  friend void protobuf_ShutdownFile_launcher_5fdump_2eproto();

  void InitAsDefaultInstance();
};
extern ::google::protobuf::internal::ExplicitlyConstructed<LauncherImpression> LauncherImpression_default_instance_;

// ===================================================================


// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
// DumpTarget

// optional .model.DumpTarget.Type type = 1;
inline bool DumpTarget::has_type() const {
  return (_has_bits_[0] & 0x00000001u) != 0;
}
inline void DumpTarget::set_has_type() {
  _has_bits_[0] |= 0x00000001u;
}
inline void DumpTarget::clear_has_type() {
  _has_bits_[0] &= ~0x00000001u;
}
inline void DumpTarget::clear_type() {
  type_ = 0;
  clear_has_type();
}
inline ::model::DumpTarget_Type DumpTarget::type() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.type)
  return static_cast< ::model::DumpTarget_Type >(type_);
}
inline void DumpTarget::set_type(::model::DumpTarget_Type value) {
  assert(::model::DumpTarget_Type_IsValid(value));
  set_has_type();
  type_ = value;
  // @@protoc_insertion_point(field_set:model.DumpTarget.type)
}

// optional int32 page_id = 2;
inline bool DumpTarget::has_page_id() const {
  return (_has_bits_[0] & 0x00000002u) != 0;
}
inline void DumpTarget::set_has_page_id() {
  _has_bits_[0] |= 0x00000002u;
}
inline void DumpTarget::clear_has_page_id() {
  _has_bits_[0] &= ~0x00000002u;
}
inline void DumpTarget::clear_page_id() {
  page_id_ = 0;
  clear_has_page_id();
}
inline ::google::protobuf::int32 DumpTarget::page_id() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.page_id)
  return page_id_;
}
inline void DumpTarget::set_page_id(::google::protobuf::int32 value) {
  set_has_page_id();
  page_id_ = value;
  // @@protoc_insertion_point(field_set:model.DumpTarget.page_id)
}

// optional int32 grid_x = 3;
inline bool DumpTarget::has_grid_x() const {
  return (_has_bits_[0] & 0x00000004u) != 0;
}
inline void DumpTarget::set_has_grid_x() {
  _has_bits_[0] |= 0x00000004u;
}
inline void DumpTarget::clear_has_grid_x() {
  _has_bits_[0] &= ~0x00000004u;
}
inline void DumpTarget::clear_grid_x() {
  grid_x_ = 0;
  clear_has_grid_x();
}
inline ::google::protobuf::int32 DumpTarget::grid_x() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.grid_x)
  return grid_x_;
}
inline void DumpTarget::set_grid_x(::google::protobuf::int32 value) {
  set_has_grid_x();
  grid_x_ = value;
  // @@protoc_insertion_point(field_set:model.DumpTarget.grid_x)
}

// optional int32 grid_y = 4;
inline bool DumpTarget::has_grid_y() const {
  return (_has_bits_[0] & 0x00000008u) != 0;
}
inline void DumpTarget::set_has_grid_y() {
  _has_bits_[0] |= 0x00000008u;
}
inline void DumpTarget::clear_has_grid_y() {
  _has_bits_[0] &= ~0x00000008u;
}
inline void DumpTarget::clear_grid_y() {
  grid_y_ = 0;
  clear_has_grid_y();
}
inline ::google::protobuf::int32 DumpTarget::grid_y() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.grid_y)
  return grid_y_;
}
inline void DumpTarget::set_grid_y(::google::protobuf::int32 value) {
  set_has_grid_y();
  grid_y_ = value;
  // @@protoc_insertion_point(field_set:model.DumpTarget.grid_y)
}

// optional .model.ContainerType container_type = 5;
inline bool DumpTarget::has_container_type() const {
  return (_has_bits_[0] & 0x00000010u) != 0;
}
inline void DumpTarget::set_has_container_type() {
  _has_bits_[0] |= 0x00000010u;
}
inline void DumpTarget::clear_has_container_type() {
  _has_bits_[0] &= ~0x00000010u;
}
inline void DumpTarget::clear_container_type() {
  container_type_ = 0;
  clear_has_container_type();
}
inline ::model::ContainerType DumpTarget::container_type() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.container_type)
  return static_cast< ::model::ContainerType >(container_type_);
}
inline void DumpTarget::set_container_type(::model::ContainerType value) {
  assert(::model::ContainerType_IsValid(value));
  set_has_container_type();
  container_type_ = value;
  // @@protoc_insertion_point(field_set:model.DumpTarget.container_type)
}

// optional .model.ItemType item_type = 6;
inline bool DumpTarget::has_item_type() const {
  return (_has_bits_[0] & 0x00000020u) != 0;
}
inline void DumpTarget::set_has_item_type() {
  _has_bits_[0] |= 0x00000020u;
}
inline void DumpTarget::clear_has_item_type() {
  _has_bits_[0] &= ~0x00000020u;
}
inline void DumpTarget::clear_item_type() {
  item_type_ = 0;
  clear_has_item_type();
}
inline ::model::ItemType DumpTarget::item_type() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.item_type)
  return static_cast< ::model::ItemType >(item_type_);
}
inline void DumpTarget::set_item_type(::model::ItemType value) {
  assert(::model::ItemType_IsValid(value));
  set_has_item_type();
  item_type_ = value;
  // @@protoc_insertion_point(field_set:model.DumpTarget.item_type)
}

// optional string package_name = 7;
inline bool DumpTarget::has_package_name() const {
  return (_has_bits_[0] & 0x00000040u) != 0;
}
inline void DumpTarget::set_has_package_name() {
  _has_bits_[0] |= 0x00000040u;
}
inline void DumpTarget::clear_has_package_name() {
  _has_bits_[0] &= ~0x00000040u;
}
inline void DumpTarget::clear_package_name() {
  package_name_.ClearToEmptyNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
  clear_has_package_name();
}
inline const ::std::string& DumpTarget::package_name() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.package_name)
  return package_name_.GetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline void DumpTarget::set_package_name(const ::std::string& value) {
  set_has_package_name();
  package_name_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), value);
  // @@protoc_insertion_point(field_set:model.DumpTarget.package_name)
}
inline void DumpTarget::set_package_name(const char* value) {
  set_has_package_name();
  package_name_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::string(value));
  // @@protoc_insertion_point(field_set_char:model.DumpTarget.package_name)
}
inline void DumpTarget::set_package_name(const char* value, size_t size) {
  set_has_package_name();
  package_name_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(),
      ::std::string(reinterpret_cast<const char*>(value), size));
  // @@protoc_insertion_point(field_set_pointer:model.DumpTarget.package_name)
}
inline ::std::string* DumpTarget::mutable_package_name() {
  set_has_package_name();
  // @@protoc_insertion_point(field_mutable:model.DumpTarget.package_name)
  return package_name_.MutableNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline ::std::string* DumpTarget::release_package_name() {
  // @@protoc_insertion_point(field_release:model.DumpTarget.package_name)
  clear_has_package_name();
  return package_name_.ReleaseNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline void DumpTarget::set_allocated_package_name(::std::string* package_name) {
  if (package_name != NULL) {
    set_has_package_name();
  } else {
    clear_has_package_name();
  }
  package_name_.SetAllocatedNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), package_name);
  // @@protoc_insertion_point(field_set_allocated:model.DumpTarget.package_name)
}

// optional string component = 8;
inline bool DumpTarget::has_component() const {
  return (_has_bits_[0] & 0x00000080u) != 0;
}
inline void DumpTarget::set_has_component() {
  _has_bits_[0] |= 0x00000080u;
}
inline void DumpTarget::clear_has_component() {
  _has_bits_[0] &= ~0x00000080u;
}
inline void DumpTarget::clear_component() {
  component_.ClearToEmptyNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
  clear_has_component();
}
inline const ::std::string& DumpTarget::component() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.component)
  return component_.GetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline void DumpTarget::set_component(const ::std::string& value) {
  set_has_component();
  component_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), value);
  // @@protoc_insertion_point(field_set:model.DumpTarget.component)
}
inline void DumpTarget::set_component(const char* value) {
  set_has_component();
  component_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::string(value));
  // @@protoc_insertion_point(field_set_char:model.DumpTarget.component)
}
inline void DumpTarget::set_component(const char* value, size_t size) {
  set_has_component();
  component_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(),
      ::std::string(reinterpret_cast<const char*>(value), size));
  // @@protoc_insertion_point(field_set_pointer:model.DumpTarget.component)
}
inline ::std::string* DumpTarget::mutable_component() {
  set_has_component();
  // @@protoc_insertion_point(field_mutable:model.DumpTarget.component)
  return component_.MutableNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline ::std::string* DumpTarget::release_component() {
  // @@protoc_insertion_point(field_release:model.DumpTarget.component)
  clear_has_component();
  return component_.ReleaseNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline void DumpTarget::set_allocated_component(::std::string* component) {
  if (component != NULL) {
    set_has_component();
  } else {
    clear_has_component();
  }
  component_.SetAllocatedNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), component);
  // @@protoc_insertion_point(field_set_allocated:model.DumpTarget.component)
}

// optional string item_id = 9;
inline bool DumpTarget::has_item_id() const {
  return (_has_bits_[0] & 0x00000100u) != 0;
}
inline void DumpTarget::set_has_item_id() {
  _has_bits_[0] |= 0x00000100u;
}
inline void DumpTarget::clear_has_item_id() {
  _has_bits_[0] &= ~0x00000100u;
}
inline void DumpTarget::clear_item_id() {
  item_id_.ClearToEmptyNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
  clear_has_item_id();
}
inline const ::std::string& DumpTarget::item_id() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.item_id)
  return item_id_.GetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline void DumpTarget::set_item_id(const ::std::string& value) {
  set_has_item_id();
  item_id_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), value);
  // @@protoc_insertion_point(field_set:model.DumpTarget.item_id)
}
inline void DumpTarget::set_item_id(const char* value) {
  set_has_item_id();
  item_id_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), ::std::string(value));
  // @@protoc_insertion_point(field_set_char:model.DumpTarget.item_id)
}
inline void DumpTarget::set_item_id(const char* value, size_t size) {
  set_has_item_id();
  item_id_.SetNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(),
      ::std::string(reinterpret_cast<const char*>(value), size));
  // @@protoc_insertion_point(field_set_pointer:model.DumpTarget.item_id)
}
inline ::std::string* DumpTarget::mutable_item_id() {
  set_has_item_id();
  // @@protoc_insertion_point(field_mutable:model.DumpTarget.item_id)
  return item_id_.MutableNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline ::std::string* DumpTarget::release_item_id() {
  // @@protoc_insertion_point(field_release:model.DumpTarget.item_id)
  clear_has_item_id();
  return item_id_.ReleaseNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited());
}
inline void DumpTarget::set_allocated_item_id(::std::string* item_id) {
  if (item_id != NULL) {
    set_has_item_id();
  } else {
    clear_has_item_id();
  }
  item_id_.SetAllocatedNoArena(&::google::protobuf::internal::GetEmptyStringAlreadyInited(), item_id);
  // @@protoc_insertion_point(field_set_allocated:model.DumpTarget.item_id)
}

// optional int32 span_x = 10 [default = 1];
inline bool DumpTarget::has_span_x() const {
  return (_has_bits_[0] & 0x00000200u) != 0;
}
inline void DumpTarget::set_has_span_x() {
  _has_bits_[0] |= 0x00000200u;
}
inline void DumpTarget::clear_has_span_x() {
  _has_bits_[0] &= ~0x00000200u;
}
inline void DumpTarget::clear_span_x() {
  span_x_ = 1;
  clear_has_span_x();
}
inline ::google::protobuf::int32 DumpTarget::span_x() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.span_x)
  return span_x_;
}
inline void DumpTarget::set_span_x(::google::protobuf::int32 value) {
  set_has_span_x();
  span_x_ = value;
  // @@protoc_insertion_point(field_set:model.DumpTarget.span_x)
}

// optional int32 span_y = 11 [default = 1];
inline bool DumpTarget::has_span_y() const {
  return (_has_bits_[0] & 0x00000400u) != 0;
}
inline void DumpTarget::set_has_span_y() {
  _has_bits_[0] |= 0x00000400u;
}
inline void DumpTarget::clear_has_span_y() {
  _has_bits_[0] &= ~0x00000400u;
}
inline void DumpTarget::clear_span_y() {
  span_y_ = 1;
  clear_has_span_y();
}
inline ::google::protobuf::int32 DumpTarget::span_y() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.span_y)
  return span_y_;
}
inline void DumpTarget::set_span_y(::google::protobuf::int32 value) {
  set_has_span_y();
  span_y_ = value;
  // @@protoc_insertion_point(field_set:model.DumpTarget.span_y)
}

// optional .model.UserType user_type = 12;
inline bool DumpTarget::has_user_type() const {
  return (_has_bits_[0] & 0x00000800u) != 0;
}
inline void DumpTarget::set_has_user_type() {
  _has_bits_[0] |= 0x00000800u;
}
inline void DumpTarget::clear_has_user_type() {
  _has_bits_[0] &= ~0x00000800u;
}
inline void DumpTarget::clear_user_type() {
  user_type_ = 0;
  clear_has_user_type();
}
inline ::model::UserType DumpTarget::user_type() const {
  // @@protoc_insertion_point(field_get:model.DumpTarget.user_type)
  return static_cast< ::model::UserType >(user_type_);
}
inline void DumpTarget::set_user_type(::model::UserType value) {
  assert(::model::UserType_IsValid(value));
  set_has_user_type();
  user_type_ = value;
  // @@protoc_insertion_point(field_set:model.DumpTarget.user_type)
}

inline const DumpTarget* DumpTarget::internal_default_instance() {
  return &DumpTarget_default_instance_.get();
}
// -------------------------------------------------------------------

// LauncherImpression

// repeated .model.DumpTarget targets = 1;
inline int LauncherImpression::targets_size() const {
  return targets_.size();
}
inline void LauncherImpression::clear_targets() {
  targets_.Clear();
}
inline const ::model::DumpTarget& LauncherImpression::targets(int index) const {
  // @@protoc_insertion_point(field_get:model.LauncherImpression.targets)
  return targets_.Get(index);
}
inline ::model::DumpTarget* LauncherImpression::mutable_targets(int index) {
  // @@protoc_insertion_point(field_mutable:model.LauncherImpression.targets)
  return targets_.Mutable(index);
}
inline ::model::DumpTarget* LauncherImpression::add_targets() {
  // @@protoc_insertion_point(field_add:model.LauncherImpression.targets)
  return targets_.Add();
}
inline ::google::protobuf::RepeatedPtrField< ::model::DumpTarget >*
LauncherImpression::mutable_targets() {
  // @@protoc_insertion_point(field_mutable_list:model.LauncherImpression.targets)
  return &targets_;
}
inline const ::google::protobuf::RepeatedPtrField< ::model::DumpTarget >&
LauncherImpression::targets() const {
  // @@protoc_insertion_point(field_list:model.LauncherImpression.targets)
  return targets_;
}

inline const LauncherImpression* LauncherImpression::internal_default_instance() {
  return &LauncherImpression_default_instance_.get();
}
#endif  // !PROTOBUF_INLINE_NOT_IN_HEADERS
// -------------------------------------------------------------------


// @@protoc_insertion_point(namespace_scope)

}  // namespace model

#ifndef SWIG
namespace google {
namespace protobuf {

template <> struct is_proto_enum< ::model::DumpTarget_Type> : ::google::protobuf::internal::true_type {};
template <>
inline const EnumDescriptor* GetEnumDescriptor< ::model::DumpTarget_Type>() {
  return ::model::DumpTarget_Type_descriptor();
}
template <> struct is_proto_enum< ::model::ItemType> : ::google::protobuf::internal::true_type {};
template <>
inline const EnumDescriptor* GetEnumDescriptor< ::model::ItemType>() {
  return ::model::ItemType_descriptor();
}
template <> struct is_proto_enum< ::model::ContainerType> : ::google::protobuf::internal::true_type {};
template <>
inline const EnumDescriptor* GetEnumDescriptor< ::model::ContainerType>() {
  return ::model::ContainerType_descriptor();
}
template <> struct is_proto_enum< ::model::UserType> : ::google::protobuf::internal::true_type {};
template <>
inline const EnumDescriptor* GetEnumDescriptor< ::model::UserType>() {
  return ::model::UserType_descriptor();
}

}  // namespace protobuf
}  // namespace google
#endif  // SWIG

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_launcher_5fdump_2eproto__INCLUDED
