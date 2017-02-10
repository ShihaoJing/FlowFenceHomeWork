/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/shihaojing/Projects/FlowFenceHomeWork/oasis2/oasis.common/src/main/aidl/edu/umich/oasis/common/IHandle.aidl
 */
package edu.umich.oasis.common;
public interface IHandle extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.umich.oasis.common.IHandle
{
private static final java.lang.String DESCRIPTOR = "edu.umich.oasis.common.IHandle";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.umich.oasis.common.IHandle interface,
 * generating a proxy if needed.
 */
public static edu.umich.oasis.common.IHandle asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.umich.oasis.common.IHandle))) {
return ((edu.umich.oasis.common.IHandle)iin);
}
return new edu.umich.oasis.common.IHandle.Stub.Proxy(obj);
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
case TRANSACTION_release:
{
data.enforceInterface(DESCRIPTOR);
this.release();
reply.writeNoException();
return true;
}
case TRANSACTION_withTaint:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.TaintSet _arg0;
if ((0!=data.readInt())) {
_arg0 = edu.umich.oasis.common.TaintSet.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
edu.umich.oasis.common.IHandle _result = this.withTaint(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_getSodaDescriptor:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.SodaDescriptor _result = this.getSodaDescriptor();
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
case TRANSACTION_getParamIndex:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getParamIndex();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getParamInfo:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.ParamInfo _result = this.getParamInfo();
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
case TRANSACTION_getDebug:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.IHandleDebug _result = this.getDebug();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_tryDeclassify:
{
data.enforceInterface(DESCRIPTOR);
boolean _arg0;
_arg0 = (0!=data.readInt());
edu.umich.oasis.common.ParceledPayloadExceptionResult _result = this.tryDeclassify(_arg0);
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
case TRANSACTION_isComplete:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isComplete();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_tryWaitForComplete:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.tryWaitForComplete();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.umich.oasis.common.IHandle
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
@Override public void release() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_release, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public edu.umich.oasis.common.IHandle withTaint(edu.umich.oasis.common.TaintSet newTaints) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.IHandle _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((newTaints!=null)) {
_data.writeInt(1);
newTaints.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_withTaint, _data, _reply, 0);
_reply.readException();
_result = edu.umich.oasis.common.IHandle.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public edu.umich.oasis.common.SodaDescriptor getSodaDescriptor() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.SodaDescriptor _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getSodaDescriptor, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.umich.oasis.common.SodaDescriptor.CREATOR.createFromParcel(_reply);
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
@Override public int getParamIndex() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getParamIndex, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public edu.umich.oasis.common.ParamInfo getParamInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.ParamInfo _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getParamInfo, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.umich.oasis.common.ParamInfo.CREATOR.createFromParcel(_reply);
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
@Override public edu.umich.oasis.common.IHandleDebug getDebug() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.IHandleDebug _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDebug, _data, _reply, 0);
_reply.readException();
_result = edu.umich.oasis.common.IHandleDebug.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Returns null if declassification is not allowed.

@Override public edu.umich.oasis.common.ParceledPayloadExceptionResult tryDeclassify(boolean mergeTaints) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.ParceledPayloadExceptionResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(((mergeTaints)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_tryDeclassify, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.umich.oasis.common.ParceledPayloadExceptionResult.CREATOR.createFromParcel(_reply);
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
@Override public boolean isComplete() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isComplete, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean tryWaitForComplete() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_tryWaitForComplete, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_release = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_withTaint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getSodaDescriptor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getParamIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getParamInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getDebug = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_tryDeclassify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_isComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_tryWaitForComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
}
public void release() throws android.os.RemoteException;
public edu.umich.oasis.common.IHandle withTaint(edu.umich.oasis.common.TaintSet newTaints) throws android.os.RemoteException;
public edu.umich.oasis.common.SodaDescriptor getSodaDescriptor() throws android.os.RemoteException;
public int getParamIndex() throws android.os.RemoteException;
public edu.umich.oasis.common.ParamInfo getParamInfo() throws android.os.RemoteException;
public edu.umich.oasis.common.IHandleDebug getDebug() throws android.os.RemoteException;
// Returns null if declassification is not allowed.

public edu.umich.oasis.common.ParceledPayloadExceptionResult tryDeclassify(boolean mergeTaints) throws android.os.RemoteException;
public boolean isComplete() throws android.os.RemoteException;
public boolean tryWaitForComplete() throws android.os.RemoteException;
}
