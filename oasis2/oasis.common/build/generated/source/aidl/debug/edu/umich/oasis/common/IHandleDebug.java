/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/shihaojing/Projects/FlowFenceHomeWork/oasis2/oasis.common/src/main/aidl/edu/umich/oasis/common/IHandleDebug.aidl
 */
package edu.umich.oasis.common;
public interface IHandleDebug extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.umich.oasis.common.IHandleDebug
{
private static final java.lang.String DESCRIPTOR = "edu.umich.oasis.common.IHandleDebug";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.umich.oasis.common.IHandleDebug interface,
 * generating a proxy if needed.
 */
public static edu.umich.oasis.common.IHandleDebug asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.umich.oasis.common.IHandleDebug))) {
return ((edu.umich.oasis.common.IHandleDebug)iin);
}
return new edu.umich.oasis.common.IHandleDebug.Stub.Proxy(obj);
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
case TRANSACTION_isComplete:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isComplete();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_waitForComplete:
{
data.enforceInterface(DESCRIPTOR);
this.waitForComplete();
reply.writeNoException();
return true;
}
case TRANSACTION_getData:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.ParceledPayloadExceptionResult _result = this.getData();
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
case TRANSACTION_getClassName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getClassName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getTaints:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.TaintSet _result = this.getTaints();
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
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.umich.oasis.common.IHandleDebug
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
@Override public void waitForComplete() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_waitForComplete, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public edu.umich.oasis.common.ParceledPayloadExceptionResult getData() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.ParceledPayloadExceptionResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getData, _data, _reply, 0);
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
@Override public java.lang.String getClassName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getClassName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public edu.umich.oasis.common.TaintSet getTaints() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.TaintSet _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTaints, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.umich.oasis.common.TaintSet.CREATOR.createFromParcel(_reply);
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
}
static final int TRANSACTION_isComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_waitForComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getClassName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getTaints = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
}
public boolean isComplete() throws android.os.RemoteException;
public void waitForComplete() throws android.os.RemoteException;
public edu.umich.oasis.common.ParceledPayloadExceptionResult getData() throws android.os.RemoteException;
public java.lang.String getClassName() throws android.os.RemoteException;
public edu.umich.oasis.common.TaintSet getTaints() throws android.os.RemoteException;
}
