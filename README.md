AndEx Alert Dialog ![API](https://img.shields.io/badge/API-17%2B-brightgreen.svg?style=flat) [![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](https://opensource.org/licenses/Apache-2.0)
===================
AndEx Alert Dialog is a library like ios alert dialog with many more features that optimized for both ltr and rtl languages.


**This library is also available at JitPack.io**

[![](https://jitpack.io/v/salehyarahmadi/AndExAlertDialog.svg)](https://jitpack.io/#salehyarahmadi/AndExAlertDialog)


`this library is compatible to androidx`

## Preview
![](https://github.com/salehyarahmadi/AndExAlertDialog/blob/master/andex-alert-dialog.gif)

## Setup
The simplest way to use this library is to add the library as dependency to your build.

## Gradle

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency

```gradle
dependencies {
	implementation 'com.github.salehyarahmadi:AndExAlertDialog:v1.0.1'
}
```

## Usage

```java
new AndExAlertDialog.Builder(context)
    .setTitle(title)
    .setMessage(message)
    .setPositiveBtnText(positiveText)
    .setNegativeBtnText(negativeText)
    .setCancelableOnTouchOutside(boolean)
    .setFont(Font.IRAN_SANS)
    .setImage(image, imagePercent)
    .setEditText(true, false, hintText, InputType.TEXT_MULTI_LINE)
    .OnPositiveClicked(positiveClickListener)
    .OnNegativeClicked(negativeClickListener)
    .setTitleTextColor(color)
    .setMessageTextColor(color)
    .setButtonTextColor(color)
    .build();
```


    - All of above featuers is optional
    - When you set positive button text, you must set OnPositiveClicked
    - When you set negative button text, you must set OnNegativeClicked
    - for setting image, you have three options:
        1- using image url  --> .setImage("http://image-url/image.jpg" , 20)
        2 -using image file  --> .setImage(new File("image-path-on-device") , 20)
        3- using image resource id in drawable  --> .setImage(R.drawable.image , 20)
    - imagePercent is actually the width of the image in percent


        
 ## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2019 AndExAlertDialog

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
       
