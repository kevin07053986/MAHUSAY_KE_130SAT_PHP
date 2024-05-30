// Generated by view binder compiler. Do not edit!
package com.mab.buwisbuddyph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mab.buwisbuddyph.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AccountantRatingListItemBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RatingBar accountantRatingBar;

  @NonNull
  public final CircleImageView userProfileImage;

  @NonNull
  public final TextView userReviews;

  private AccountantRatingListItemBinding(@NonNull RelativeLayout rootView,
      @NonNull RatingBar accountantRatingBar, @NonNull CircleImageView userProfileImage,
      @NonNull TextView userReviews) {
    this.rootView = rootView;
    this.accountantRatingBar = accountantRatingBar;
    this.userProfileImage = userProfileImage;
    this.userReviews = userReviews;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AccountantRatingListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AccountantRatingListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.accountant_rating_list_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AccountantRatingListItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.accountantRatingBar;
      RatingBar accountantRatingBar = ViewBindings.findChildViewById(rootView, id);
      if (accountantRatingBar == null) {
        break missingId;
      }

      id = R.id.userProfileImage;
      CircleImageView userProfileImage = ViewBindings.findChildViewById(rootView, id);
      if (userProfileImage == null) {
        break missingId;
      }

      id = R.id.userReviews;
      TextView userReviews = ViewBindings.findChildViewById(rootView, id);
      if (userReviews == null) {
        break missingId;
      }

      return new AccountantRatingListItemBinding((RelativeLayout) rootView, accountantRatingBar,
          userProfileImage, userReviews);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
