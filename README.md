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

The DataGateway currently offers only a couple of methods to access the imei, last known locations (both coarse and fine grained) and to send data via http POST.

-----
Tasks
-----

### Task1: Firebase Android app
1. Follow Firebase instructions: [Firebase](https://firebase.google.com/docs/android/setup)
2. Basic functions:
	* Use app to store presence information in Realtime Database of Firebase.
	* Authorization is required.
	* Presence information can be {location: home} or {location: away} key-value pair.
	
### Task2: Presence Based Smart Switch Control
1. Implements a presence publisher app that can listen to data change in your Firebase app and broadcast presence information out.
	* Presence information must be able to be received by any other apps.
2. Implements a presence receiver app that can listen to presence publisher and control SmartThings switch according to different events.
	* SmartThings APIs are in SmartThingsService module.
	* Add the dependency for SmartThingsService module to your app-level build.gradle file:
	```java
   	 	compile project(':smartthingsservice')
 	```
	* Try to switch on/off an switch (we only have one).
	* Use curl command to check state of switch:
	```
	curl -H "Authorization: Bearer 80019c76-29c8-4c7d-9856-b19834b94a7b" "https://graph-na02-useast1.api.smartthings.com:443/api/smartapps/installations/8785b29c-2fe6-405f-9f29-0dd21adceffb/switchstate/4d5fc6f1-b288-4847-bc05-e3b535ff77cb"
	```
3. Assume your presence receiver app is malicious. Try to send presence information to your own server and print it out.

### Task3: Fenced Presence Based Smart Switch Control
1. Requirement: Use FlowFence (Oasis) system to secure your presence information. 
2. Instructions:
	* Complete 'fencedpresencepublisher' and 'fencedpresenceresponder' module in oasis2. The frame has already been given. Now operations on sensitive data must be in Soda (Quarantine  Module).
	* For 'fencedpresencepublisher' module, complete PrensenceInjector and Prensence. For 'fencedpresenceresponder' module, complete ResponderService and ResponderSoda.
	* Refer to 'oasis.study.skeleton' module when you try to figure out how to invoke functions in Soda and how to fire an event channel.
	* Send presence information in 'fencedpresenceresponder' using Trusted API to your server (see checklist).
	* If previous step failed, try to modify policy file 'oasis_manifest.xml' in res/xml folder in 'fencedpresencepublisher' module and see what will happend. ('oasis.study.skeleton' module has same XML file)

### Checklist
* Before doing task3, make sure oasis.service installed in your android device (There should be a 'edu.umich.oasis.service' process in Android Monitor of Android Studio.
* Refer to [OKHTTP](http://square.github.io/okhttp/) when you try to do HTTP in task2.
* Refer to oasis.skeleton app when you are doing task3. HTTP API can be found in package 'edu.umich.oasis.service.service.TrustedAPI'. SmartThings API can be found in package 'edu.umich.oasis.smartthings.SmartThingsService'.
	* Get Dynamic API handler ('HTTPRequest' method):
	```java
    	IDynamicAPI api = (IDynamicAPI)OASISContext.getInstance().getTrustedAPI("push");
        api.invoke("HTTPRequest", "http://192.168.0.4:5000/upload", LOC_KEY, presence);
 	```


