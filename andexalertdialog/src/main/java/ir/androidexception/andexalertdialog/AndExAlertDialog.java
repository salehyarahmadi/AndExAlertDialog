package ir.androidexception.andexalertdialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.res.ResourcesCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.io.File;


public class AndExAlertDialog {

    public static class Builder {
        private static final int URL = 1;
        private static final int DEVICE = 2;
        private static final int RESOURCE = 3;
        private int imageType = 0;

        private Context context;
        private String title, message, positiveBtnText, negativeBtnText;
        private String imageUrl;
        private File imageFile;
        @DrawableRes private int imageResourceId;
        private int imagePercent = 40;
        private boolean showEditText;
        private boolean rtl;
        private String hintText;
        private InputType inputType;
        private int buttonTextColor, titleTextColor, messageTextColor, fontId;
        private boolean cancelOnTouchOutside = true;
        private AndExAlertDialogListener positiveListener, negativeListener;
        private Animation animation;
        private Font font;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setAnimation(Animation animation) {
            this.animation = animation;
            return this;
        }

        public Builder setCancelableOnTouchOutside(boolean cancelOnTouchOutside) {
            this.cancelOnTouchOutside = cancelOnTouchOutside;
            return this;
        }

        public Builder setFont(Font font) {
            this.font = font;
            return this;
        }

        public Builder setCustomFont(int fontId) {
            this.fontId = fontId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setImage(String imageUrl, int imagePercent){
            this.imageUrl = imageUrl;
            this.imagePercent = imagePercent;
            this.imageType = URL;
            return this;
        }
        public Builder setImage(File imageFile, int imagePercent){
            this.imageFile = imageFile;
            this.imagePercent = imagePercent;
            this.imageType = DEVICE;
            return this;
        }
        public Builder setImage(int imageResourceId, int imagePercent){
            this.imageResourceId = imageResourceId;
            this.imagePercent = imagePercent;
            this.imageType = RESOURCE;
            return this;
        }

        public Builder setEditText(boolean showEditText, boolean rtl, String hintText, InputType inputType){
            this.showEditText = showEditText;
            this.hintText = hintText;
            this.inputType = inputType;
            this.rtl = rtl;
            return this;
        }


        public Builder setTitleTextColor(int titleTextColor) {
            this.titleTextColor = titleTextColor;
            return this;
        }

        public Builder setMessageTextColor(int messageTextColor) {
            this.messageTextColor = messageTextColor;
            return this;
        }


        public Builder setButtonTextColor(int buttonTextColor) {
            this.buttonTextColor = buttonTextColor;
            return this;
        }

        public Builder setPositiveBtnText(String positiveBtnText) {
            this.positiveBtnText = positiveBtnText;
            return this;
        }

        public Builder setNegativeBtnText(String negativeBtnText) {
            this.negativeBtnText = negativeBtnText;
            return this;
        }

        public Builder OnPositiveClicked(AndExAlertDialogListener positiveListener) {
            this.positiveListener = positiveListener;
            return this;
        }

        public Builder OnNegativeClicked(AndExAlertDialogListener negativeListener) {
            this.negativeListener = negativeListener;
            return this;
        }

        public void build() {
            int style;
            if (animation == Animation.UP) style = R.style.AndExUpTheme;
            else if (animation == Animation.DOWN) style = R.style.AndExDownTheme;
            else style = 0;

            final AlertDialog dialog = style != 0 ?
                    new AlertDialog.Builder(context, style).create() :
                    new AlertDialog.Builder(context).create();

            dialog.setCanceledOnTouchOutside(cancelOnTouchOutside);

            @SuppressLint("InflateParams")
            View v = LayoutInflater.from(context).inflate(R.layout.andex_alert_dialog_layout, null);
            dialog.setView(v);

            if (dialog.getWindow() != null) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }

            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

            TextView tvTitle = v.findViewById(R.id.tv_andex_alert_dialog_layout_title),
                    tvMessage = v.findViewById(R.id.tv_andex_alert_dialog_layout_message);

            ImageView imageView = v.findViewById(R.id.iv_andex_alert_dialog_layout_image);

            final EditText editText = v.findViewById(R.id.et_andex_alert_dialog_layout_input);

            TextView btnNegativeText = v.findViewById(R.id.tv_andex_alert_dialog_layout_cancel_text),
                     btnPositiveText = v.findViewById(R.id.tv_andex_alert_dialog_layout_confirm_text);

            View btnNegative = v.findViewById(R.id.v_andex_alert_dialog_layout_cancel),
                 btnPositive = v.findViewById(R.id.v_andex_alert_dialog_layout_confirm);

            View buttonDivider = v.findViewById(R.id.v_andex_alert_dialog_layout_button_divider);

            Guideline leftImageGL = v.findViewById(R.id.gl_andex_alert_dialog_layout_image_left),
                      rightImageGL = v.findViewById(R.id.gl_andex_alert_dialog_layout_image_right);

            if (font != null) {
                Typeface tf,tfb = null;
                if (font == Font.COMFORTAA) {
                    tf = ResourcesCompat.getFont(context, R.font.comfortaa);
                } else if (font == Font.FINGER_PAINT) {
                    tf = ResourcesCompat.getFont(context, R.font.finger_paint);
                } else if (font == Font.QUICK_SAND) {
                    tf = ResourcesCompat.getFont(context, R.font.quicksand_medium);
                } else if(font == Font.IRAN_SANS) {
                    tf = ResourcesCompat.getFont(context, R.font.iran_sans);
                    tfb = ResourcesCompat.getFont(context, R.font.iran_sans_bold);
                } else {
                    tf = ResourcesCompat.getFont(context, R.font.quicksand_medium);
                }

                if(font == Font.IRAN_SANS) {
                    tvTitle.setTypeface(tfb);
                    btnPositiveText.setTypeface(tfb);
                }
                else {
                    tvTitle.setTypeface(tf);
                    btnPositiveText.setTypeface(tf);
                }
                tvMessage.setTypeface(tf);
                editText.setTypeface(tf);
                btnNegativeText.setTypeface(tf);
            }

            if (fontId != 0) {
                Typeface tf = ResourcesCompat.getFont(context, fontId);
                tvTitle.setTypeface(tf);
                tvMessage.setTypeface(tf);
                editText.setTypeface(tf);
                btnPositiveText.setTypeface(tf);
                btnNegativeText.setTypeface(tf);
            }

            if(title!=null)
                tvTitle.setText(title);
            else
                tvTitle.setVisibility(View.GONE);

            if(message!=null)
                tvMessage.setText(message);
            else
                tvMessage.setVisibility(View.GONE);


            if(imageType == URL){
                Glide.with(context)
                        .load(Uri.parse(imageUrl))
                        .into(imageView);
            }
            else if(imageType == DEVICE){
                Glide.with(context)
                        .load(Uri.fromFile(imageFile))
                        .into(imageView);
            }
            else if(imageType == RESOURCE){
                imageView.setImageResource(imageResourceId);
            }
            else{
                imageView.setVisibility(View.GONE);
            }


            if(imagePercent<100) {
                int tmp = 100 - imagePercent;
                float leftPercent = ((float) tmp / 2) / 100;
                float rightPercent = (((float) tmp / 2) + imagePercent) / 100;
                ConstraintLayout.LayoutParams paramsL = (ConstraintLayout.LayoutParams) leftImageGL.getLayoutParams();
                paramsL.guidePercent = leftPercent;
                leftImageGL.setLayoutParams(paramsL);
                ConstraintLayout.LayoutParams paramsR = (ConstraintLayout.LayoutParams) rightImageGL.getLayoutParams();
                paramsR.guidePercent = rightPercent;
                rightImageGL.setLayoutParams(paramsR);
            }

            if(showEditText){
                editText.setVisibility(View.VISIBLE);
            }
            else{
                editText.setVisibility(View.GONE);
            }

            editText.setLayoutDirection(rtl ? View.LAYOUT_DIRECTION_RTL : View.LAYOUT_DIRECTION_LTR);

            if(hintText!=null){
                editText.setHint(hintText);
            }

            if(inputType == InputType.TEXT_SINGLE_LINE)
                editText.setInputType(android.text.InputType.TYPE_CLASS_TEXT);
            else if(inputType == InputType.TEXT_MULTI_LINE)
                editText.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            else if(inputType == InputType.NUMBER)
                editText.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
            else if(inputType == InputType.PASSWORD)
                editText.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);
            else
                editText.setInputType(android.text.InputType.TYPE_CLASS_TEXT);





            if (titleTextColor != 0) {
                tvTitle.setTextColor(titleTextColor);
            }

            if (messageTextColor != 0) {
                tvMessage.setTextColor(messageTextColor);
            }

            if (buttonTextColor != 0) {
                btnPositiveText.setTextColor(buttonTextColor);
                btnNegativeText.setTextColor(buttonTextColor);
            }

            if (positiveBtnText != null) {
                btnPositiveText.setText(positiveBtnText);
            }

            if (negativeBtnText != null) {
                btnNegativeText.setText(negativeBtnText);
            }

            if (positiveListener != null) {
                btnPositive.setVisibility(View.VISIBLE);
                btnPositive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        positiveListener.OnClick(editText.getVisibility()==View.VISIBLE ? editText.getText().toString() : "");
                        dialog.dismiss();
                    }
                });

            } else {
                btnPositive.setVisibility(View.GONE);
            }

            if (negativeListener != null) {
                btnNegative.setVisibility(View.VISIBLE);
                btnNegative.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        negativeListener.OnClick(editText.getVisibility()==View.VISIBLE ? editText.getText().toString() : "");
                        dialog.dismiss();
                    }
                });
            } else {
                btnNegative.setVisibility(View.GONE);
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) buttonDivider.getLayoutParams();
                params.horizontalBias = 0f;
                buttonDivider.setLayoutParams(params);
            }


            dialog.show();
        }
    }
}
