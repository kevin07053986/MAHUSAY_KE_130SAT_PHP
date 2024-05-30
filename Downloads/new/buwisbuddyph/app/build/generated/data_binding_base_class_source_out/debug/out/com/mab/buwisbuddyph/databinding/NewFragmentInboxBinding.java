// Generated by view binder compiler. Do not edit!
package com.mab.buwisbuddyph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mab.buwisbuddyph.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class NewFragmentInboxBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RelativeLayout appName;

  @NonNull
  public final TextView appNameTV;

  @NonNull
  public final ImageView backIcon;

  @NonNull
  public final RecyclerView recyclerView;

  private NewFragmentInboxBinding(@NonNull LinearLayout rootView, @NonNull RelativeLayout appName,
      @NonNull TextView appNameTV, @NonNull ImageView backIcon,
      @NonNull RecyclerView recyclerView) {
    this.rootView = rootView;
    this.appName = appName;
    this.appNameTV = appNameTV;
    this.backIcon = backIcon;
    this.recyclerView = recyclerView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static NewFragmentInboxBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NewFragmentInboxBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.new_fragment_inbox, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NewFragmentInboxBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appName;
      RelativeLayout appName = ViewBindings.findChildViewById(rootView, id);
      if (appName == null) {
        break missingId;
      }

      id = R.id.appNameTV;
      TextView appNameTV = ViewBindings.findChildViewById(rootView, id);
      if (appNameTV == null) {
        break missingId;
      }

      id = R.id.back_icon;
      ImageView backIcon = ViewBindings.findChildViewById(rootView, id);
      if (backIcon == null) {
        break missingId;
      }

      id = R.id.recyclerView;
      RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, id);
      if (recyclerView == null) {
        break missingId;
      }

      return new NewFragmentInboxBinding((LinearLayout) rootView, appName, appNameTV, backIcon,
          recyclerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
