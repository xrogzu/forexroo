package com.github.xuzw.forexroo.crm.div;

import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;
import com.github.xuzw.ui_engine_runtime.div.container.Wrapper;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月16日 上午12:16:47
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "background-color", value = "rgb(245, 245, 245)"), //
                @StyleDeclarationAnnotation(property = "overflow", value = "hidden"), //
        }) })
public class Background extends Wrapper {

    public Background(Div element) {
        super(element);
    }
}
