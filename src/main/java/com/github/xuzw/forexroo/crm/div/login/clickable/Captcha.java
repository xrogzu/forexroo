package com.github.xuzw.forexroo.crm.div.login.clickable;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.ClickableDiv;
import com.github.xuzw.ui_engine_runtime.event.ClickEvent;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月16日 下午1:06:09
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "position", value = "absolute"), //
                @StyleDeclarationAnnotation(property = "transform", value = "translate(281px, -42px);"), //
        }), })
public class Captcha extends ClickableDiv {

    public Captcha() {
        super(Event.class);
    }

    @Override
    protected void buildClickableDiv(HtmlBuilder clickableDiv) {
        clickableDiv.child("img").src("captcha?complexity=99&size=20&length=5");
    }

    public static class Event extends ClickEvent {
        @Override
        public void onClick() {
            System.out.println("q");
        }
    }
}
