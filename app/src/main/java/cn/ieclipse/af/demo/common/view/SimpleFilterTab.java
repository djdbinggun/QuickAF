/*
 * Copyright (C) 2015-2016 adviser2
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ieclipse.af.demo.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/**
 * Description
 *
 * @author Jamling
 */
public class SimpleFilterTab extends ToggleButton {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SimpleFilterTab(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public SimpleFilterTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SimpleFilterTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleFilterTab(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable[] drawables = getCompoundDrawables();
        if (drawables != null) {
            Drawable drawableLeft = drawables[2]; // right drawable
            if (drawableLeft != null) {
                CharSequence text = getText();
                if (TextUtils.isEmpty(text)) {
                    text = getHint();
                }
                float textWidth = 0;
                if (!TextUtils.isEmpty(text)) {
                    textWidth = getPaint().measureText(text.toString());
                }
                int drawablePadding = getCompoundDrawablePadding();
                int drawableWidth = 0;
                drawableWidth = drawableLeft.getIntrinsicWidth();
                float bodyWidth = textWidth + drawableWidth + drawablePadding;
                float middle = (getMeasuredWidth() - bodyWidth) / 2;
                if (middle > 0) {
                    canvas.translate(-middle, 0);
                }
            }
        }
        super.onDraw(canvas);
    }
}
