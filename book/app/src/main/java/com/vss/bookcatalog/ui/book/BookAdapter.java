package com.vss.bookcatalog.ui.book;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.vss.bookcatalog.R;
import com.vss.bookcatalog.data.model.Book;
import com.vss.bookcatalog.utils.ConstansUtils;
import com.vss.bookcatalog.utils.ImageUtil;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    private Context context;
    private List<Book> bookList;

    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view =  layoutInflater.inflate(R.layout.item_book_view, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        final Book book = bookList.get(position);
        holder.tvBookTitle.setText(book.title);
       // holder.ivBookImage.setImageResource(book.getThumbnail());

        ImageUtil.fetchImage(context, book.thumbnail, holder.ivBookImage);

        holder.cvCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookDetailActivity.class);

                intent.putExtra(ConstansUtils.TITLE_KEY, book.title);
                intent.putExtra(ConstansUtils.CATEGORY_KEY, book.category);
                intent.putExtra(ConstansUtils.DESCRIPTION_KEY, book.description);
                intent.putExtra(ConstansUtils.THUMBNAILS_KEY, book.thumbnail);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder{


        TextView tvBookTitle;
        ImageView ivBookImage;
        CardView cvCard;

        public BookViewHolder(View itemView) {
            super(itemView);

            tvBookTitle = itemView.findViewById(R.id.bookTitle);
            ivBookImage = itemView.findViewById(R.id.bookImage);
            cvCard = itemView.findViewById(R.id.cardViewItem);

        }
    }
}
