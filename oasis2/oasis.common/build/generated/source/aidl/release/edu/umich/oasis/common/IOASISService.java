/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/shihaojing/Projects/FlowFenceHomeWork/oasis2/oasis.common/src/main/aidl/edu/umich/oasis/common/IOASISService.aidl
 */
package edu.umich.oasis.common;
public interface IOASISService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.umich.oasis.common.IOASISService
{
private static final java.lang.String DESCRIPTOR = "edu.umich.oasis.common.IOASISService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.umich.oasis.common.IOASISService interface,
 * generating a proxy if needed.
 */
public static edu.umich.oasis.common.IOASISService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.umich.oasis.common.IOASISService))) {
return ((edu.umich.oasis.common.IOASISService)iin);
}
return new edu.umich.oasis.common.IOASISService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_resolveSODA:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.SodaDescriptor _arg0;
if ((0!=data.readInt())) {
_arg0 = edu.umich.oasis.common.SodaDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
int _arg1;
_arg1 = data.readInt();
edu.umich.oasis.common.SodaDetails _arg2;
if ((0!=data.readInt())) {
_arg2 = edu.umich.oasis.common.SodaDetails.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
edu.umich.oasis.common.SodaExceptionResult _result = this.resolveSODA(_arg0, _arg1, _arg2);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
if ((_arg2!=null)) {
reply.writeInt(1);
_arg2.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_setSandboxCount:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.setSandboxCount(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setMaxIdleCount:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.setMaxIdleCount(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setMinHotSpare:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.setMinHotSpare(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_setMaxHotSpare:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _result = this.setMaxHotSpare(_arg0);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_restartSandbox:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.restartSandbox(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_subscribeEventChannel:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
edu.umich.oasis.common.SodaDescriptor _arg1;
if ((0!=data.readInt())) {
_arg1 = edu.umich.oasis.common.SodaDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
edu.umich.oasis.common.ExceptionResult _result = this.subscribeEventChannel(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_unsubscribeEventChannel:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
edu.umich.oasis.common.SodaDescriptor _arg1;
if ((0!=data.readInt())) {
_arg1 = edu.umich.oasis.common.SodaDescriptor.CREATOR.createFromParcel(data);
}
else {
_arg1 = null;
}
edu.umich.oasis.common.ExceptionResult _result = this.unsubscribeEventChannel(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_subscribeEventChannelHandle:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
edu.umich.oasis.common.ISoda _arg1;
_arg1 = edu.umich.oasis.common.ISoda.Stub.asInterface(data.readStrongBinder());
edu.umich.oasis.common.ExceptionResult _result = this.subscribeEventChannelHandle(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_unsubscribeEventChannelHandle:
{
data.enforceInterface(DESCRIPTOR);
android.content.ComponentName _arg0;
if ((0!=data.readInt())) {
_arg0 = android.content.ComponentName.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
edu.umich.oasis.common.ISoda _arg1;
_arg1 = edu.umich.oasis.common.ISoda.Stub.asInterface(data.readStrongBinder());
edu.umich.oasis.common.ExceptionResult _result = this.unsubscribeEventChannelHandle(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_forceGarbageCollection:
{
data.enforceInterface(DESCRIPTOR);
this.forceGarbageCollection();
reply.writeNoException();
return true;
}
case TRANSACTION_dumpMemoryInfo:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<android.os.Debug.MemoryInfo> _arg0;
_arg0 = new java.util.ArrayList<android.os.Debug.MemoryInfo>();
android.os.Debug.MemoryInfo _result = this.dumpMemoryInfo(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
reply.writeTypedList(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.umich.oasis.common.IOASISService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
//client app facing API

@Override public edu.umich.oasis.common.SodaExceptionResult resolveSODA(edu.umich.oasis.common.SodaDescriptor descriptor, int flags, edu.umich.oasis.common.SodaDetails details) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.SodaExceptionResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((descriptor!=null)) {
_data.writeInt(1);
descriptor.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeInt(flags);
if ((details!=null)) {
_data.writeInt(1);
details.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_resolveSODA, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.umich.oasis.common.SodaExceptionResult.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
if ((0!=_reply.readInt())) {
details.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int setSandboxCount(int count) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(count);
mRemote.transact(Stub.TRANSACTION_setSandboxCount, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int setMaxIdleCount(int count) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(count);
mRemote.transact(Stub.TRANSACTION_setMaxIdleCount, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int setMinHotSpare(int count) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(count);
mRemote.transact(Stub.TRANSACTION_setMinHotSpare, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public int setMaxHotSpare(int count) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(count);
mRemote.transact(Stub.TRANSACTION_setMaxHotSpare, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void restartSandbox(int sandboxId) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(sandboxId);
mRemote.transact(Stub.TRANSACTION_restartSandbox, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public edu.umich.oasis.common.ExceptionResult subscribeEventChannel(android.content.ComponentName channel, edu.umich.oasis.common.SodaDescriptor descriptor) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.ExceptionResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((channel!=null)) {
_data.writeInt(1);
channel.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((descriptor!=null)) {
_data.writeInt(1);
descriptor.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_subscribeEventChannel, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.umich.oasis.common.ExceptionResult.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public edu.umich.oasis.common.ExceptionResult unsubscribeEventChannel(android.content.ComponentName channel, edu.umich.oasis.common.SodaDescriptor descriptor) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.ExceptionResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((channel!=null)) {
_data.writeInt(1);
channel.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
if ((descriptor!=null)) {
_data.writeInt(1);
descriptor.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_unsubscribeEventChannel, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.umich.oasis.common.ExceptionResult.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public edu.umich.oasis.common.ExceptionResult subscribeEventChannelHandle(android.content.ComponentName channel, edu.umich.oasis.common.ISoda sodaRef) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.ExceptionResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((channel!=null)) {
_data.writeInt(1);
channel.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((sodaRef!=null))?(sodaRef.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_subscribeEventChannelHandle, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.umich.oasis.common.ExceptionResult.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public edu.umich.oasis.common.ExceptionResult unsubscribeEventChannelHandle(android.content.ComponentName channel, edu.umich.oasis.common.ISoda sodaRef) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.ExceptionResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((channel!=null)) {
_data.writeInt(1);
channel.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeStrongBinder((((sodaRef!=null))?(sodaRef.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unsubscribeEventChannelHandle, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.umich.oasis.common.ExceptionResult.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Debugging and experiment stuff. Requires holding DEBUG_OASIS_SERVICE permission.

@Override public void forceGarbageCollection() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_forceGarbageCollection, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public android.os.Debug.MemoryInfo dumpMemoryInfo(java.util.List<android.os.Debug.MemoryInfo> sandboxInfo) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.Debug.MemoryInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_dumpMemoryInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.Debug.MemoryInfo.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
_reply.readTypedList(sandboxInfo, android.os.Debug.MemoryInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_resolveSODA = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_setSandboxCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_setMaxIdleCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_setMinHotSpare = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_setMaxHotSpare = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_restartSandbox = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_subscribeEventChannel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_unsubscribeEventChannel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_subscribeEventChannelHandle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_unsubscribeEventChannelHandle = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_forceGarbageCollection = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_dumpMemoryInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
}
//client app facing API

public edu.umich.oasis.common.SodaExceptionResult resolveSODA(edu.umich.oasis.common.SodaDescriptor descriptor, int flags, edu.umich.oasis.common.SodaDetails details) throws android.os.RemoteException;
public int setSandboxCount(int count) throws android.os.RemoteException;
public int setMaxIdleCount(int count) throws android.os.RemoteException;
public int setMinHotSpare(int count) throws android.os.RemoteException;
public int setMaxHotSpare(int count) throws android.os.RemoteException;
public void restartSandbox(int sandboxId) throws android.os.RemoteException;
public edu.umich.oasis.common.ExceptionResult subscribeEventChannel(android.content.ComponentName channel, edu.umich.oasis.common.SodaDescriptor descriptor) throws android.os.RemoteException;
public edu.umich.oasis.common.ExceptionResult unsubscribeEventChannel(android.content.ComponentName channel, edu.umich.oasis.common.SodaDescriptor descriptor) throws android.os.RemoteException;
public edu.umich.oasis.common.ExceptionResult subscribeEventChannelHandle(android.content.ComponentName channel, edu.umich.oasis.common.ISoda sodaRef) throws android.os.RemoteException;
public edu.umich.oasis.common.ExceptionResult unsubscribeEventChannelHandle(android.content.ComponentName channel, edu.umich.oasis.common.ISoda sodaRef) throws android.os.RemoteException;
// Debugging and experiment stuff. Requires holding DEBUG_OASIS_SERVICE permission.

public void forceGarbageCollection() throws android.os.RemoteException;
public android.os.Debug.MemoryInfo dumpMemoryInfo(java.util.List<android.os.Debug.MemoryInfo> sandboxInfo) throws android.os.RemoteException;
}
