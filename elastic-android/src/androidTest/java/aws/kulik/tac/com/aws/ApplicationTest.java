package aws.kulik.tac.com.aws;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.elastictranscoder.model.AccessDeniedException;
import com.amazonaws.services.elastictranscoder.model.IncompatibleVersionException;
import com.amazonaws.services.elastictranscoder.model.InternalServiceException;
import com.amazonaws.services.elastictranscoder.model.LimitExceededException;
import com.amazonaws.services.elastictranscoder.model.ResourceNotFoundException;
import com.amazonaws.services.elastictranscoder.model.ValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

public class ApplicationTest extends ApplicationTestCase<Application> {
    private static final String TAG = "ApplicatioonTest";

    public ApplicationTest() {
        super(Application.class);
    }

    public void testElastic() {
        File file = new File("/sdcard/VID1.mp4");
        String uid = UUID.randomUUID().toString().toUpperCase();
        String name = generateName(file, uid, Constants.VIDEO_NAME);
        try {
            AWS.uploadFile(file, name, Constants.VIDEO_INPUT_BUCKET);
        } catch (FileNotFoundException e) {
            Log.e(TAG, "", e);
        } catch (AmazonServiceException e) {
            Log.e(TAG, "", e);
        } catch (AmazonClientException e) {
            Log.e(TAG, "", e);
        } catch (IOException e) {
            Log.e(TAG, "", e);
        }
        Log.d(TAG, "UpLoad file" + file.getPath() + " has finished");
        try {
            AWS.transcode(name, uid);
        } catch (ResourceNotFoundException e) {
            Log.e(TAG, "", e);
        } catch (AccessDeniedException e) {
            Log.e(TAG, "", e);
        } catch (InternalServiceException e) {
            Log.e(TAG, "", e);
        } catch (LimitExceededException e) {
            Log.e(TAG, "", e);
        } catch (ValidationException e) {
            Log.e(TAG, "", e);
        } catch (IncompatibleVersionException e) {
            Log.e(TAG, "", e);
        } catch (AmazonServiceException e) {
            Log.e(TAG, "", e);
        } catch (AmazonClientException e) {
            Log.e(TAG, "", e);
        }
    }

    public String generateName(File file, String uid, String prefix) {
        String path = file.getPath();
        int pointPos = path.lastIndexOf(".");
        String ext = (pointPos > 0) ? path.substring(pointPos) : "";

        return prefix + "-" + uid + ext;
    };
}