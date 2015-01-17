package aws.kulik.tac.com.aws;

import android.util.Log;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.elastictranscoder.AmazonElasticTranscoder;
import com.amazonaws.services.elastictranscoder.AmazonElasticTranscoderClient;
import com.amazonaws.services.elastictranscoder.model.CreateJobOutput;
import com.amazonaws.services.elastictranscoder.model.CreateJobRequest;
import com.amazonaws.services.elastictranscoder.model.CreateJobResult;
import com.amazonaws.services.elastictranscoder.model.JobInput;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by kulik on 15.01.15.
 */
public class AWS {

    private static final String TAG = AWS.class.getSimpleName();

    public static void uploadFile(final File file, String name, String bucket) throws IOException {
        AmazonS3Client s3Client = new AmazonS3Client(
                new BasicAWSCredentials(Constants.ACCESS_KEY_ID,
                        Constants.SECRET_KEY));
        FileInputStream fs = new MyIS(file);
        final long filesize = file.length();
        ObjectMetadata metadata = new ObjectMetadata();
        //TODO Pay attention
//            metadata.setContentType("file/jpeg");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, name, fs, metadata);
        putObjectRequest.setGeneralProgressListener(new ProgressListener() {
            @Override
            public void progressChanged(ProgressEvent progressEvent) {

                long transfered = progressEvent.getBytesTransferred();
                float progress = (float) transfered / filesize;
                Log.d(TAG, "Transfered " + progress);
            }
        });
        s3Client.putObject(putObjectRequest);
        fs.close();
    }


    public static void transcode(String name, String uid) {
        JobInput jobInput = new JobInput();

        jobInput.setKey(Constants.VIDEO_INPUT_BUCKET + "/" + name);
        jobInput.setFrameRate("auto");
        jobInput.setResolution("auto");
        jobInput.setAspectRatio("auto");
        jobInput.setInterlaced("auto");
        jobInput.setContainer("auto");
//        @"Output": @{@"Key": [NSString stringWithFormat: @"media-%@.mp4", objectUid],
//            @"Rotate": @"auto",
//            @"PresetId": TRANSCODE_PRESET_ID,
//            @"ThumbnailPattern": [NSString stringWithFormat: @"thumb-%@-{count}", objectUid]}
        CreateJobOutput output = new CreateJobOutput();
        output.setKey(String.format("media-%s.mp4", uid));
        output.setRotate("auto");
        output.setPresetId(Constants.TRANSCODE_PRESET_ID);
        output.setThumbnailPattern(String.format("thumb-%s-{count}", uid));
        CreateJobRequest createJobRequest = new CreateJobRequest();
        createJobRequest.setInput(jobInput);
        createJobRequest.setOutput(output);
        createJobRequest.setPipelineId(Constants.TRANSCODE_PIPELINE_ID);
//        AmazonS3Client s3Client = new AmazonS3Client(
//                new BasicAWSCredentials(Constants.ACCESS_KEY_ID,
//                        Constants.SECRET_KEY));
//        s3Client.

        BasicAWSCredentials credentials = new BasicAWSCredentials(Constants.ACCESS_KEY_ID, Constants.SECRET_KEY);
        AmazonElasticTranscoder elastic = new AmazonElasticTranscoderClient(credentials);
        Region region = Region.getRegion(Regions.EU_WEST_1);
        elastic.setRegion(region);
        CreateJobResult createJobResult = elastic.createJob(createJobRequest);
    }
}
