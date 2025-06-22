package uk.ac.le.co2103.part2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.nio.channels.NonReadableChannelException;

public class CreateListActivity extends AppCompatActivity {

    private static final String TAG = CreateListActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "uk.edu.le.co2103.hw4.REPLY";

    public static final String EXTRA_REPLY_2 = "Image";
    public static String n;

    EditText name;
    Button BSelectImage;
    ImageView IVPreviewImage;
    Button createButton;

    int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_create_list);

        name = findViewById(R.id.name);
        BSelectImage = findViewById(R.id.BSelectImage);
        IVPreviewImage = findViewById(R.id.IVPreviewImage);

//        if(bitimage != null) {
//            int width = bitimage.getWidth();
//            int height = bitimage.getHeight();
//            IVPreviewImage.setImageBitmap(bitimage);
//            // do something with the bitmap
//        } else {
//            // handle the case when bitmap is null
//            IVPreviewImage.setImageResource(R.drawable.standard);
//        }

        createButton = findViewById(R.id.createButton);

        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        final Button createB = findViewById(R.id.createButton);
        createB.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(name.getText())) {
                Log.i(TAG, "Empty text field could be controlled in UI (Save button disabled)");
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                Log.i(TAG, "Adding item to list");
                n = name.getText().toString();

                IVPreviewImage.setDrawingCacheEnabled(true);
                Bitmap bitimage = Bitmap.createBitmap(IVPreviewImage.getDrawingCache());
                IVPreviewImage.setDrawingCacheEnabled(false);
                replyIntent.putExtra(EXTRA_REPLY, n);
                replyIntent.putExtra(EXTRA_REPLY_2, bitmapToByteArray(bitimage));
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });

//        createButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String listName = name.getText().toString();
//                startActivity(new Intent(CreateListActivity.this, MainActivity.class));
//            }
//        });
    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }

    private String imageToString(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream .toByteArray();

        String imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
        return imageString;
    }


    private byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        return b;
    }

    private Bitmap stringToBitmap(String string){
        Bitmap bitmap = null;

        try {
            byte[] encodeByte = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return bitmap;
    }

}