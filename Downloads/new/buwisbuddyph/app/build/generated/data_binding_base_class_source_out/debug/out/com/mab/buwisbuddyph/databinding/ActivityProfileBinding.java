// Generated by view binder compiler. Do not edit!
package com.mab.buwisbuddyph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public final class ActivityProfileBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout appName;

  @NonNull
  public final TextView appNameTV;

  @NonNull
  public final Button editButton;

  @NonNull
  public final EditText emailTV;

  @NonNull
  public final EditText genderTV;

  @NonNull
  public final TextView logoutTV;

  @NonNull
  public final RelativeLayout main;

  @NonNull
  public final EditText nameTV;

  @NonNull
  public final EditText numberTV;

  @NonNull
  public final ImageView returnIcon;

  @NonNull
  public final TextView settingsTV;

  @NonNull
  public final EditText tinTV;

  @NonNull
  public final CircleImageView userProfileImg;

  private ActivityProfileBinding(@NonNull RelativeLayout rootView, @NonNull LinearLayout appName,
      @NonNull TextView appNameTV, @NonNull Button editButton, @NonNull EditText emailTV,
      @NonNull EditText genderTV, @NonNull TextView logoutTV, @NonNull RelativeLayout main,
      @NonNull EditText nameTV, @NonNull EditText numberTV, @NonNull ImageView returnIcon,
      @NonNull TextView settingsTV, @NonNull EditText tinTV,
      @NonNull CircleImageView userProfileImg) {
    this.rootView = rootView;
    this.appName = appName;
    this.appNameTV = appNameTV;
    this.editButton = editButton;
    this.emailTV = emailTV;
    this.genderTV = genderTV;
    this.logoutTV = logoutTV;
    this.main = main;
    this.nameTV = nameTV;
    this.numberTV = numberTV;
    this.returnIcon = returnIcon;
    this.settingsTV = settingsTV;
    this.tinTV = tinTV;
    this.userProfileImg = userProfileImg;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appName;
      LinearLayout appName = ViewBindings.findChildViewById(rootView, id);
      if (appName == null) {
        break missingId;
      }

      id = R.id.appNameTV;
      TextView appNameTV = ViewBindings.findChildViewById(rootView, id);
      if (appNameTV == null) {
        break missingId;
      }

      id = R.id.editButton;
      Button editButton = ViewBindings.findChildViewById(rootView, id);
      if (editButton == null) {
        break missingId;
      }

      id = R.id.emailTV;
      EditText emailTV = ViewBindings.findChildViewById(rootView, id);
      if (emailTV == null) {
        break missingId;
      }

      id = R.id.genderTV;
      EditText genderTV = ViewBindings.findChildViewById(rootView, id);
      if (genderTV == null) {
        break missingId;
      }

      id = R.id.logoutTV;
      TextView logoutTV = ViewBindings.findChildViewById(rootView, id);
      if (logoutTV == null) {
        break missingId;
      }

      RelativeLayout main = (RelativeLayout) rootView;

      id = R.id.nameTV;
      EditText nameTV = ViewBindings.findChildViewById(rootView, id);
      if (nameTV == null) {
        break missingId;
      }

      id = R.id.numberTV;
      EditText numberTV = ViewBindings.findChildViewById(rootView, id);
      if (numberTV == null) {
        break missingId;
      }

      id = R.id.returnIcon;
      ImageView returnIcon = ViewBindings.findChildViewById(rootView, id);
      if (returnIcon == null) {
        break missingId;
      }

      id = R.id.settingsTV;
      TextView settingsTV = ViewBindings.findChildViewById(rootView, id);
      if (settingsTV == null) {
        break missingId;
      }

      id = R.id.tinTV;
      EditText tinTV = ViewBindings.findChildViewById(rootView, id);
      if (tinTV == null) {
        break missingId;
      }

      id = R.id.userProfileImg;
      CircleImageView userProfileImg = ViewBindings.findChildViewById(rootView, id);
      if (userProfileImg == null) {
        break missingId;
      }

      return new ActivityProfileBinding((RelativeLayout) rootView, appName, appNameTV, editButton,
          emailTV, genderTV, logoutTV, main, nameTV, numberTV, returnIcon, settingsTV, tinTV,
          userProfileImg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
