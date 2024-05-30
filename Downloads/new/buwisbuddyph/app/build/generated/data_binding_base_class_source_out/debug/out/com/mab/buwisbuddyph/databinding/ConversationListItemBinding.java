// Generated by view binder compiler. Do not edit!
package com.mab.buwisbuddyph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mab.buwisbuddyph.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ConversationListItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView conversationTV;

  private ConversationListItemBinding(@NonNull LinearLayout rootView,
      @NonNull TextView conversationTV) {
    this.rootView = rootView;
    this.conversationTV = conversationTV;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ConversationListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ConversationListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.conversation_list_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ConversationListItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.conversationTV;
      TextView conversationTV = ViewBindings.findChildViewById(rootView, id);
      if (conversationTV == null) {
        break missingId;
      }

      return new ConversationListItemBinding((LinearLayout) rootView, conversationTV);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
