package codecomplete.tnp.moviehub;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AsyncTaskLoadImage extends AsyncTask<String, String, Bitmap> {
    private final static String TAG = "AsyncTaskLoadImage";
    private ImageView imageView;
    private int width = 0, height = 0;

    public AsyncTaskLoadImage(ImageView imageView, int width, int height) {
        this.imageView = imageView;
        this.width = width;
        this.height = height;
    }

    public AsyncTaskLoadImage(ImageView imageView) {
        this.imageView = imageView;

    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(params[0]);
            bitmap = BitmapFactory.decodeStream((InputStream) url.getContent());
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        if (width != 0) return getResizedBitmap(bitmap, width, height);
        return bitmap;
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}
