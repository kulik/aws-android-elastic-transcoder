/*
* Copyright 2010-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License").
* You may not use this file except in compliance with the License.
* A copy of the License is located at
*
*  http://aws.amazon.com/apache2.0
*
* or in the "license" file accompanying this file. This file is distributed
* on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
* express or implied. See the License for the specific language governing
* permissions and limitations under the License.
*/
package aws.kulik.tac.com.aws;

public class Constants {
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This sample App is for demonstration purposes only.
    // It is not secure to embed your credentials into source code.
    // DO NOT EMBED YOUR CREDENTIALS IN PRODUCTION APPS.
    // We offer two solutions for getting credentials to your mobile App.
    // Please read the following article to learn about Token Vending Machine:
    // * http://aws.amazon.com/articles/Mobile/4611615499399490
    // Or consider using web identity federation:
    // * http://aws.amazon.com/articles/Mobile/4617974389850313
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static final String ACCESS_KEY_ID = "Your one";
    public static final String SECRET_KEY = "Your one";

    public static final String VIDEO_NAME = "kulikv";

    public static final String VIDEO_INPUT_BUCKET = "patina-video-input";

    public static final String TRANSCODE_PIPELINE_ID = "your one";
    public static final String TRANSCODE_PRESET_ID = "your one";
    public static final String TRANSCODE_PIPELINE_REGION = "eu-west-1";

//    public static String getPictureBucket() {
//        return ("input-my-unique-name" + ACCESS_KEY_ID + PICTURE_BUCKET).toLowerCase(Locale.US);
//    }


}
