package org.fieldcontrols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Table {

    private WebElement tableElement;
    private List<String> columns;
    private List<WebElement> columnElements;
    private List<WebElement> rowElements;
    private final static String HEADER_XPATH = ".//thead//th";
    private final static String ROW_XPATH = ".//tbody//tr";


    public Table (WebElement element) {
        if (element == null) throw new NullPointerException("Unable to create a table on a null element!");
        this.tableElement = element;
        init();
    }

    private void init() {

        this.columnElements = tableElement.findElements(By.xpath(HEADER_XPATH));
        this.rowElements = tableElement.findElements(By.xpath(ROW_XPATH));

        this.columns = this.columnElements.stream()
                .map(column -> column.getText().trim())
                .collect(Collectors.toList());
    }

    public int getColumnIndexOf(String column) {
        if (!this.columns.contains(column)) throw new IllegalArgumentException(String.format("Column '%s' is not visible in page!"));

        return this.columns.indexOf(column);
    }

    public List<WebElement> getRowElements() {
        return this.rowElements;
    }

    public boolean isEmpty() {
        return rowElements.isEmpty();
    }


}
