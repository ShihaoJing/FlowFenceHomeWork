-----------
Intro
-----------
FlowFence, a system that enables robust and efficient flow control between sources and sinks in IoT applications. FlowFence addresses several challenges including not requiring the use of specialpurpose languages, avoiding implicit flows, not requiring instruction-level information flow control, supporting flow policy rules for IoT apps, as well as IoT-specific challenges like supporting diverse app flows involving a variety of device data sources.

A previous iteration of this system was called OASIS. We will refactor class names to FlowFence and update the repo soon. For now, all of the classes will be named "oasis"

Terminology Map (this will not be needed after refactor is complete): Quarantined Module (QM in FlowFence): Sensitive Operation Defined By The Application (SODA in OASIS)

The refactor will simply change SODA to QM and OASIS to FlowFence. 

-------------
Basic Steps
-----------

1. Install JDK8 (Oracle), and make sure JAVA_HOME is set correctly to point to this. Update gradle if it asks you.

	* make sure you have a working android studio env (flowfence uses Android SDK Platform 22, build tools 22.0.1)
	* Startup Android studio, open project "oasis2" and let a gradle build proceed.

2. Build project (if running for first time, it will download and install a bunch of stuff. This is okay.)
3. cd oasis.service
	
    * The oasis.service APK will be inside build/outputs/apk
	* Install this apk manually to a device
	* adb install -r apk_name

4. Start Android Studio and launch oasis.skeleton

MAKE SURE TO DISABLE INSTARUN!

* oasis.test contains sample Quarantined Modules (or SODAs, Sensitive Operation ).

* This will bring up a client app which contains examples on how to build apps with SODAs (also known as QMs), and how to play with SmartThings.

At this point, flowfence (oasis) is deployed and ready.

------------------
SmartThings Bridge
------------------

The SmartThings bridge enables oasis to communicate with physical devices that are managed by smartthings. We built a webservices smartapp that exposes various methods that can be called remotely from the oasis framework. This requires negotiating an OAuth token. The current code directly embeds this token (which is unsafe). A more production ready implementation has to negotiate this token at runtime and store it securely (e.g., encrypted under a password when at rest).

--------------------------
Miscellaenous Design Notes
--------------------------

Policy file is in /res/xml/oasis_manifest.xml.
The policy is loaded when the service is started explicitly and/or when a client binds to the service. (oasis behaves as a started service if started explicitly via the gui or as a bound service if it's started by the binding of a client).

Permissions are defined in OASISCommon/src/com/temporary/oasiscommon/OASISPerm.java, in the enumerator PermissionsEnum. 
Adding a new permissions is a matter of adding a field to the enum, and adding methods that use this permission in the DataGateway (both in the aidl interface and the implementation).
Permissions are managed with a BitSet (which is a set of bits, just to state the obvious): a 1 (set) bit means the usage of the relative permission.
This allows for quick policy checks (every entry in the policy allows,denies or require user intervention for one or more permissions, and that can be expressed with another BitSet: checking a policy entry is a matter of doing a boolean AND between the two sets and checking if the result is equal to the policy entry or not), is efficient and is not limited to the number of bits for the integer implementation.

The DataGateway currently offers only a couple of methods to access the imei, last known locations (both coarse and fine grained) and to send data via http POST.

-----
Tasks
-----

### Task1: Firebase Android app
1. Follow Firebase instructions: [Firebase](https://firebase.google.com/docs/android/setup)
2. Basic functions:
	* Use app to store presence information in Realtime Database of Firebase
	* Authorization is required.
	* Presence information can be {location: home} or {location: away} key-value pair
### Task2: Presence Based Smart Switch Control
1. Implements a presence publisher app that can listen to data change in your Firebase app and broadcast presence information out.
	* Presence information must be able to be received by any other apps.
2. Implements a presence receiver app that can listen to presence publisher and control SmartThings switch according to different events.
	* SmartThings APIs are in SmartThingsService module. Try to switch on/off an switch (we only have one) and use API to check if operations are executed successfully (whether state of switch changed).
	
3. Assume your presence receiver app is malicious. Try to send presence information to your own server and print it out.
### Task3: Fenced Presence Based Smart Switch Control
1. Use FlowFence (Oasis) system to secure your presence information. Complete 'fencedpresencepublisher' and 'fencedpresenceresponder' module in oasis2. The frame has already been given. Now operation on sensitive data must be in Soda (Quarantine  Module).
2. Perform sensitive data stealing attack you have done in task2. Try to figure out why sensitive data is protected now.
### Checklist
* Before doing task3, build and install oasis.service in your android device following basic steps section.
* Do not use network functions in main thread, include SmartThings API. Your app will crash when you try to block main thread.
* Refer to [OKHTTP](http://square.github.io/okhttp/) when you try to do HTTP in task2.
* Refer to oasis.skeleton app when you are doing task3. HTTP API can be found in package 'edu.umich.oasis.service.service.TrustedAPI'. SmartThings API can be found in package 'edu.umich.oasis.smartthings.SmartThingsService'.
	* Get Dynamic API handler ('sendPush' method):
	```java
    IDynamicAPI api = (IDynamicAPI) OASISContext.getInstance().getTrustedAPI("push");
   	api.invoke("sendPush", "title", "body");
 	```
* Complete policy file 'oasis_manifest.xml' in res/xml folder in 'fencedpresencepublisher' module. Refer to same policy file in oasis.skeleton app. Try to modify policy file and see what will happend.


