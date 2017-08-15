/*
 * Copyright (c) 2017-present Ilhasoft.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.ilhasoft.support.validation.util;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john-mac on 5/21/16.
 */
public class ViewTagHelper {

    public static <Type> void appendValue(int tagId, View view, Type value) {
        Object object = view.getTag(tagId);
        if(object != null && object instanceof List) {
            ((List<Type>)object).add(value);
        } else {
            List<Type> typeList = new ArrayList<>();
            typeList.add(value);
            view.setTag(tagId, typeList);
        }
    }

    public static List<View> getViewsByTag(ViewGroup root, int tagId) {
        List<View> views = new ArrayList<>();
        final int childCount = root.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = root.getChildAt(i);
            if (child instanceof ViewGroup) {
                views.addAll(getViewsByTag((ViewGroup) child, tagId));
            }
            addViewWhenContainsTag(tagId, views, child);
        }
        return views;
    }

    public static List<View> filterViewWithTag(int tagId, View view) {
        List<View> viewsWithTags = new ArrayList<>();
        addViewWhenContainsTag(tagId, viewsWithTags, view);
        return viewsWithTags;
    }

    public static <ViewType extends View> List<View> filterViewsWithTag(int tagId, List<ViewType> views) {
        List<View> viewsWithTags = new ArrayList<>();
        for (View view : views) {
            addViewWhenContainsTag(tagId, viewsWithTags, view);
        }
        return viewsWithTags;
    }

    private static void addViewWhenContainsTag(int tagId, List<View> views, View view) {
        final Object tagValue = view.getTag(tagId);
        if (tagValue != null) {
            views.add(view);
        }
    }

}
