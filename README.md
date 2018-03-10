# MobtextingSMSLibrary
# Sending SMS from Mobtexting Platform

### Step 1. Add the JitPack repository to your build file 
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### Step 2. Add the dependency

```
	dependencies {
		compile 'com.github.dkgupta2501:SMSLibrary:2877a2f88f'
	}
```

## Send SMS using  POST Method 

```
        Map<String, String> paramVal = new HashMap<>();
        paramVal.put("api_key", "xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        paramVal.put("message", "this is a test");
        paramVal.put("mobile_no", "72********");
        paramVal.put("message_type", "normal");
        paramVal.put("content_type", "");
        paramVal.put("sender_id", "******");
        MobtextingSMS.MobtextingAPICallBackResponse(new APIResponseInterface() {
            @Override
            public void onSuccessResponse(String s) {
                Log.d("response", s);
            }

            @Override
            public void onFailureResponse(String s) {
                Log.d("response", s);
            }
        }, paramVal, "http://api.mobtexting.com/v1/sms", Method.METHOD_POST, MainActivity.this);
```
## Send SMS using  GET Method 

```
        Map<String, String> paramVal1 = new HashMap<>();
        paramVal1.put("api_key", "xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        paramVal1.put("message", "this is a test");
        paramVal1.put("mobile_no", "72********");
        paramVal1.put("message_type", "normal");
        paramVal1.put("content_type", "");
        paramVal1.put("sender_id", "******");
        MobtextingSMS.MobtextingAPICallBackResponse(new APIResponseInterface() {
            @Override
            public void onSuccessResponse(String s) {
                Log.d("response", s);
            }

            @Override
            public void onFailureResponse(String s) {
                Log.d("response", s);
            }
        }, paramVal1, "http://api.mobtexting.com/v1/sms", Method.METHOD_GET, MainActivity.this);
        
```        
