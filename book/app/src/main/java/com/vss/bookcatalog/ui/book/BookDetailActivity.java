package com.vss.bookcatalog.ui.book;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vss.bookcatalog.R;
import com.vss.bookcatalog.utils.ConstansUtils;
import com.vss.bookcatalog.utils.ImageUtil;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvTitle = findViewById(R.id.tvBookTitle);
        TextView tvCategory = findViewById(R.id.tvBookCategory);
        TextView tvDescription = findViewById(R.id.tvBookDescription);
        ImageView imgThumbnail = findViewById(R.id.bookImageThumbnail);


        //Receiving data from previous screen

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString(ConstansUtils.TITLE_KEY);
        String category = bundle.getString(ConstansUtils.CATEGORY_KEY);
        String description = bundle.getString(ConstansUtils.DESCRIPTION_KEY);
        String thumbnail = bundle.getString(ConstansUtils.THUMBNAILS_KEY);

        // Set data

        tvTitle.setText(title);
        tvCategory.setText(category);
        tvDescription.setText(description);
        ImageUtil.fetchImage(this, thumbnail, imgThumbnail);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
