package com.example.tema3;

/*
public class MySingleton {
  private static MySingleton instance;
  private RequestQueue requestQueue;
  private ImageLoader imageLoader;
  private static Context ctx;

  private MySingleton(Context context){
      ctx=context;
      requestQueue=getRequestQueue();

      imageLoader=new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
          private final LruCache<String, Bitmap>
          cache=new LruCache<(String, Bitmap)>(20);
          @Override
          public Bitmap getBitmap(String url) {
              return null;
          }

          @Override
          public void putBitmap(String url, Bitmap bitmap) {

          }
      })
  }
}
*/