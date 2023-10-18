package com.example.c323_midtermproject;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.c323_midtermproject.databinding.FragmentGameViewBindingImpl;
import com.example.c323_midtermproject.databinding.FragmentHighScoreBindingImpl;
import com.example.c323_midtermproject.databinding.FragmentMainBindingImpl;
import com.example.c323_midtermproject.databinding.FragmentMainBindingLandImpl;
import com.example.c323_midtermproject.databinding.ScoreItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTGAMEVIEW = 1;

  private static final int LAYOUT_FRAGMENTHIGHSCORE = 2;

  private static final int LAYOUT_FRAGMENTMAIN = 3;

  private static final int LAYOUT_SCOREITEM = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.c323_midtermproject.R.layout.fragment_game_view, LAYOUT_FRAGMENTGAMEVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.c323_midtermproject.R.layout.fragment_high_score, LAYOUT_FRAGMENTHIGHSCORE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.c323_midtermproject.R.layout.fragment_main, LAYOUT_FRAGMENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.c323_midtermproject.R.layout.score_item, LAYOUT_SCOREITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTGAMEVIEW: {
          if ("layout/fragment_game_view_0".equals(tag)) {
            return new FragmentGameViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_game_view is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHIGHSCORE: {
          if ("layout/fragment_high_score_0".equals(tag)) {
            return new FragmentHighScoreBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_high_score is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTMAIN: {
          if ("layout-land/fragment_main_0".equals(tag)) {
            return new FragmentMainBindingLandImpl(component, view);
          }
          if ("layout/fragment_main_0".equals(tag)) {
            return new FragmentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_main is invalid. Received: " + tag);
        }
        case  LAYOUT_SCOREITEM: {
          if ("layout/score_item_0".equals(tag)) {
            return new ScoreItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for score_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "score");
      sKeys.put(2, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/fragment_game_view_0", com.example.c323_midtermproject.R.layout.fragment_game_view);
      sKeys.put("layout/fragment_high_score_0", com.example.c323_midtermproject.R.layout.fragment_high_score);
      sKeys.put("layout-land/fragment_main_0", com.example.c323_midtermproject.R.layout.fragment_main);
      sKeys.put("layout/fragment_main_0", com.example.c323_midtermproject.R.layout.fragment_main);
      sKeys.put("layout/score_item_0", com.example.c323_midtermproject.R.layout.score_item);
    }
  }
}
