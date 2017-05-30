package com.github.xuzw.forexroo.crm.ui.main.dealer.table;

import com.github.xuzw.html_builder.HtmlBuilder;
import com.github.xuzw.ui_engine_runtime.annotation.StyleAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleBlockAnnotation;
import com.github.xuzw.ui_engine_runtime.annotation.StyleDeclarationAnnotation;
import com.github.xuzw.ui_engine_runtime.div.Div;

/**
 * @author 徐泽威 xuzewei_2012@126.com
 * @time 2017年5月30日 下午3:45:43
 */
@StyleAnnotation({ //
        @StyleBlockAnnotation({ //
                @StyleDeclarationAnnotation(property = "margin-top", value = "16px"), //
                @StyleDeclarationAnnotation(property = "margin-left", value = "16px"), //
                @StyleDeclarationAnnotation(property = "margin-right", value = "16px"), //
        }), @StyleBlockAnnotation(selector = ">table", value = { //
                @StyleDeclarationAnnotation(property = "width", value = "100%"), //
                @StyleDeclarationAnnotation(property = "border-collapse", value = "collapse"), //
                @StyleDeclarationAnnotation(property = "text-align", value = "center"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #eeeeee"), //
        }), @StyleBlockAnnotation(selector = ">table tr td", value = { //
                @StyleDeclarationAnnotation(property = "height", value = "48px"), //
                @StyleDeclarationAnnotation(property = "font-size", value = "12px"), //
                @StyleDeclarationAnnotation(property = "font-weight", value = "500"), //
                @StyleDeclarationAnnotation(property = "color", value = "#666666"), //
                @StyleDeclarationAnnotation(property = "border", value = "solid 1px #eeeeee"), //
        }), @StyleBlockAnnotation(selector = ">table>thead>tr", value = { //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ffffff"), //
        }), @StyleBlockAnnotation(selector = ">table>tbody>tr:nth-of-type(odd)", value = { //
                @StyleDeclarationAnnotation(property = "background-color", value = "#f9f9f9"), //
        }), @StyleBlockAnnotation(selector = ">table>tbody>tr:nth-of-type(even)", value = { //
                @StyleDeclarationAnnotation(property = "background-color", value = "#ffffff"), //
        }), })
public class Table extends Div {

    @Override
    protected void build(HtmlBuilder div) {
        HtmlBuilder table = div.child("table");
        buildTableHeader(table.child("thead"));
        buildTableBody(table.child("tbody"));
    }

    private void buildTableHeader(HtmlBuilder thead) {
        HtmlBuilder header = thead.child("tr");
        header.child("td").text("头像");
        header.child("td").text("昵称");
        header.child("td").text("交易商名称");
        header.child("td").text("交易账号");
        header.child("td").text("MT4账号");
        header.child("td").text("注册日期");
        header.child("td").text("开户日期");
        header.child("td").text("状态");
        header.child("td").text("所属经纪人");
        header.child("td").text("所属代理商");
        header.child("td").text("详细资料");
        header.child("td").text("操作");
    }

    private void buildTableBody(HtmlBuilder tbody) {
        for (int i = 0; i < 9; i++) {
            buildTableRow(tbody.child("tr"));
        }
    }

    private void buildTableRow(HtmlBuilder tr) {
        tr.child("td").text("头像");
        tr.child("td").text("西门吹雪");
        tr.child("td").text("陈绍鹏");
        tr.child("td").text("123456789");
        tr.child("td").text("MT4-215465");
        tr.child("td").text("2016-10-25");
        tr.child("td").text("2016-10-25");
        tr.child("td").text("正常");
        tr.child("td").text("陈绍鹏");
        tr.child("td").text("北京新行情有限公司");
        tr.child("td").text("查看");
        tr.child("td").text("设置");
    }
}
