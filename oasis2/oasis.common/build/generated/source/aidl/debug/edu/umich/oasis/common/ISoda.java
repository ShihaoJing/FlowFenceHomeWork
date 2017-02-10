/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/shihaojing/Projects/FlowFenceHomeWork/oasis2/oasis.common/src/main/aidl/edu/umich/oasis/common/ISoda.aidl
 */
package edu.umich.oasis.common;
public interface ISoda extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.umich.oasis.common.ISoda
{
private static final java.lang.String DESCRIPTOR = "edu.umich.oasis.common.ISoda";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.umich.oasis.common.ISoda interface,
 * generating a proxy if needed.
 */
public static edu.umich.oasis.common.ISoda asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.umich.oasis.common.ISoda))) {
return ((edu.umich.oasis.common.ISoda)iin);
}
return new edu.umich.oasis.common.ISoda.Stub.Proxy(obj);
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
case TRANSACTION_getDescriptor:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.SodaDescriptor _result = this.getDescriptor();
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
case TRANSACTION_getResultType:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getResultType();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getParamInfo:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<edu.umich.oasis.common.ParamInfo> _result = this.getParamInfo();
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
case TRANSACTION_getRequiredTaints:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.TaintSet _result = this.getRequiredTaints();
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
case TRANSACTION_getOptionalTaints:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.TaintSet _result = this.getOptionalTaints();
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
case TRANSACTION_getDetails:
{
data.enforceInterface(DESCRIPTOR);
edu.umich.oasis.common.SodaDetails _arg0;
if ((0!=data.readInt())) {
_arg0 = edu.umich.oasis.common.SodaDetails.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.getDetails(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_call:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.util.List<edu.umich.oasis.common.CallParam> _arg1;
_arg1 = data.createTypedArrayList(edu.umich.oasis.common.CallParam.CREATOR);
edu.umich.oasis.common.TaintSet _arg2;
if ((0!=data.readInt())) {
_arg2 = edu.umich.oasis.common.TaintSet.CREATOR.createFromParcel(data);
}
else {
_arg2 = null;
}
edu.umich.oasis.common.CallResult _result = this.call(_arg0, _arg1, _arg2);
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
private static class Proxy implements edu.umich.oasis.common.ISoda
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
@Override public edu.umich.oasis.common.SodaDescriptor getDescriptor() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.SodaDescriptor _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getDescriptor, _data, _reply, 0);
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
@Override public java.lang.String getResultType() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getResultType, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<edu.umich.oasis.common.ParamInfo> getParamInfo() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<edu.umich.oasis.common.ParamInfo> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getParamInfo, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(edu.umich.oasis.common.ParamInfo.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public edu.umich.oasis.common.TaintSet getRequiredTaints() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.TaintSet _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getRequiredTaints, _data, _reply, 0);
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
@Override public edu.umich.oasis.common.TaintSet getOptionalTaints() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.TaintSet _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getOptionalTaints, _data, _reply, 0);
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
@Override public void getDetails(edu.umich.oasis.common.SodaDetails details) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((details!=null)) {
_data.writeInt(1);
details.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getDetails, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
details.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public edu.umich.oasis.common.CallResult call(int flags, java.util.List<edu.umich.oasis.common.CallParam> params, edu.umich.oasis.common.TaintSet extraTaint) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.umich.oasis.common.CallResult _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(flags);
_data.writeTypedList(params);
if ((extraTaint!=null)) {
_data.writeInt(1);
extraTaint.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_call, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.umich.oasis.common.CallResult.CREATOR.createFromParcel(_reply);
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
static final int TRANSACTION_getDescriptor = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getResultType = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getParamInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getRequiredTaints = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getOptionalTaints = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_getDetails = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_call = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
}
public edu.umich.oasis.common.SodaDescriptor getDescriptor() throws android.os.RemoteException;
public java.lang.String getResultType() throws android.os.RemoteException;
public java.util.List<edu.umich.oasis.common.ParamInfo> getParamInfo() throws android.os.RemoteException;
public edu.umich.oasis.common.TaintSet getRequiredTaints() throws android.os.RemoteException;
public edu.umich.oasis.common.TaintSet getOptionalTaints() throws android.os.RemoteException;
public void getDetails(edu.umich.oasis.common.SodaDetails details) throws android.os.RemoteException;
public edu.umich.oasis.common.CallResult call(int flags, java.util.List<edu.umich.oasis.common.CallParam> params, edu.umich.oasis.common.TaintSet extraTaint) throws android.os.RemoteException;
}
