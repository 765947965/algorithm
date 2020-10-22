import test.Span;

import java.awt.*;

/**
 * @ProjectName: planning
 * @Package: com.xwl.yaru.planning.business.note.bean
 * @ClassName: FontSpan
 * @Description: java类作用描述
 * @Author: 谢文良
 * @CreateDate: 2020/7/7 15:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/7/7 15:39
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class FontSpan extends Span {
    private int fontColor = 11111;
    private int fontBackColor = 22222;
    private boolean boldFace = false;
    private boolean italic = false;
    private boolean underline = false;
    private boolean strikethrough = false;
    private int fontBaseSize;
    private float scalingFactor = 1f;
    private String content;

    public int getFontColor() {
        return fontColor;
    }

    public void setFontColor(int fontColor) {
        this.fontColor = fontColor;
    }

    public int getFontBackColor() {
        return fontBackColor;
    }

    public void setFontBackColor(int fontBackColor) {
        this.fontBackColor = fontBackColor;
    }

    public boolean isBoldFace() {
        return boldFace;
    }

    public void setBoldFace(boolean boldFace) {
        this.boldFace = boldFace;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public boolean isUnderline() {
        return underline;
    }

    public void setUnderline(boolean underline) {
        this.underline = underline;
    }

    public boolean isStrikethrough() {
        return strikethrough;
    }

    public void setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    public int getFontBaseSize() {
        return fontBaseSize;
    }

    public void setFontBaseSize(int fontBaseSize) {
        this.fontBaseSize = fontBaseSize;
    }

    public float getScalingFactor() {
        return scalingFactor;
    }

    public void setScalingFactor(float scalingFactor) {
        this.scalingFactor = scalingFactor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getSpanType());
        stringBuilder.append(",");
        if (fontColor != 11111) {
            stringBuilder.append(fontColor);
        }
        stringBuilder.append(",");
        if (fontBackColor != 22222) {
            stringBuilder.append(fontBackColor);
        }
        stringBuilder.append(",");
        stringBuilder.append(String.valueOf((boldFace ? 1 : 0)) + (italic ? 1 : 0)
                + (underline ? 1 : 0) + (strikethrough ? 1 : 0));
        stringBuilder.append(",");
        if (scalingFactor != 1.0f) {
            String scalingFactor = this.scalingFactor + "";
            if (scalingFactor.length() > 3) {
                scalingFactor = scalingFactor.substring(0, 3);
            }
            stringBuilder.append(scalingFactor);
        }
        stringBuilder.append(",");
        stringBuilder.append(content);
        return stringBuilder.toString();
    }

    public static FontSpan format(String input) {
        FontSpan fontSpan = new FontSpan();
        int oldIndex = 2;
        int index = input.indexOf(",", oldIndex);
        if (index != oldIndex) {
            fontSpan.setFontColor(Integer.parseInt(input.substring(oldIndex, index)));
        }
        oldIndex = index + 1;
        index = input.indexOf(",", oldIndex);
        if (index != oldIndex) {
            fontSpan.setFontBackColor(Integer.parseInt(input.substring(oldIndex, index)));
        }
        oldIndex = index + 1;
        index = input.indexOf(",", oldIndex);
        if (index != oldIndex) {
            String booleanValue = input.substring(oldIndex, index);
            if (booleanValue.charAt(0) == '1') {
                fontSpan.setBoldFace(true);
            }
            if (booleanValue.charAt(1) == '1') {
                fontSpan.setItalic(true);
            }
            if (booleanValue.charAt(2) == '1') {
                fontSpan.setUnderline(true);
            }
            if (booleanValue.charAt(3) == '1') {
                fontSpan.setStrikethrough(true);
            }
        }
        oldIndex = index + 1;
        index = input.indexOf(",", oldIndex);
        if (index != oldIndex) {
            fontSpan.setScalingFactor(Float.parseFloat(input.substring(oldIndex, index)));
        }
        oldIndex = index + 1;
        fontSpan.setContent(input.substring(oldIndex));
        return fontSpan;
    }
}
