package com.example.sanjeev.imageslideshow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.logging.Handler;

import me.relex.circleindicator.SnackbarBehavior;


public class SlideShowAdapter extends PagerAdapter {
    Handler handler;
    Runnable runnable;
    Timer timer;

    private Context context;
    LayoutInflater inflater;
public  int[] images={
        R.drawable.angrybirds,
        R.drawable.asphalt8,
        R.drawable.cuttherope,
        R.drawable.fruitninja,
        R.drawable.worms3,
        R.drawable.pou
};
    public SlideShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view=inflater.inflate(R.layout.slideshow_layout,container,false);
        ImageView img=(ImageView)view.findViewById(R.id.imageView_id);
       // img.setImageResource(images[position]);
        Glide.with(context).load(images[position]).into(img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view,"Image"+(position+1), Snackbar.LENGTH_LONG).show();

            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
