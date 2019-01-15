package com.eangulee.springbootdemo.config.locale;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.LocaleResolver;

import com.eangulee.springbootdemo.common.utils.StringUtils;

public class LanguageLocaleResolver implements LocaleResolver {

	private static final String I18N_LANGUAGE = "l";
	private static final String I18N_LANGUAGE_SESSION = "i18n_language_session";

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String i18n_language = request.getParameter(I18N_LANGUAGE);
		Locale locale = null;
		if (!StringUtils.isBlank(i18n_language)) {
			String[] language = i18n_language.split("_");
			locale = new Locale(language[0], language[1]);

			// 将国际化语言保存到session
			HttpSession session = request.getSession();
			session.setAttribute(I18N_LANGUAGE_SESSION, locale);
		} else {
			// 如果没有带国际化参数，则判断session有没有保存，有保存，则使用保存的，也就是之前设置的，避免之后的请求不带国际化参数造成语言显示不对
			HttpSession session = request.getSession();
			Locale localeInSession = (Locale) session.getAttribute(I18N_LANGUAGE_SESSION);
			if (localeInSession != null) {
				locale = localeInSession;
			}
		}
		if (locale == null)
			locale = Locale.getDefault();
		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub

	}

}
