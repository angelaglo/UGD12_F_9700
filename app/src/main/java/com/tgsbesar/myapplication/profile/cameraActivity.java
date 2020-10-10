package com.tgsbesar.myapplication.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.tgsbesar.myapplication.MainActivity;
import com.tgsbesar.myapplication.R;

public class cameraActivity extends AppCompatActivity {

    //camera activity
    private static final int CAMERA_PERMISSION_CODE = 100;
    private Camera mCamera=null;
    private cameraView mCameraView=null;
    private ImageButton close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        //checking permission
        checkPermission(Manifest.permission.CAMERA,
                CAMERA_PERMISSION_CODE);

        try{
            mCamera= Camera.open();
        }catch (Exception e){
            Log.d("Error","Failed to get camera"+e.getMessage());
        }

        if(mCamera!=null){

            mCameraView= new cameraView(this, mCamera);
            FrameLayout camera_view = findViewById(R.id.FLCamera);
            camera_view.addView(mCameraView);

        }

        close=findViewById(R.id.imgClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }


    public void checkPermission(String permission, int requestCode)
    {

        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(this,
                permission)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat
                    .requestPermissions(
                            this,
                            new String[] { permission },
                            requestCode);
        }
        else {
            Toast
                    .makeText(this,
                            "Permission already granted",
                            Toast.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode,
                permissions,
                grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {

            // check permission granted
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this,
                        "Camera Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }
            else {
                Toast.makeText(this,
                        "Camera Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }

    }
}