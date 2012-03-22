<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
Map<String, PortletURL> addArticleURLs = getAddArticleURLs(liferayPortletRequest, liferayPortletResponse);
%>

<liferay-ui:icon-menu align="left" direction="down" icon="" message="add" showExpanded="<%= false %>" showWhenSingleIcon="<%= true %>">

	<%
	if (JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ARTICLE)) {
		for (Map.Entry<String, PortletURL> entry : addArticleURLs.entrySet()) {
			String className = entry.getKey();

			String message = "basic-web-content";

			int pos = className.indexOf(_CLASSNAME_SEPARATOR);

			if (pos != -1) {
				message = className.substring(pos + _CLASSNAME_SEPARATOR.length());

				className = className.substring(0, pos);
			}

			AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);

			PortletURL addArticleURL = entry.getValue();

			addArticleURL.setParameter("groupId", String.valueOf(scopeGroupId));
	%>

			<liferay-ui:icon
				message="<%= message %>"
				src="<%= assetRendererFactory.getIconPath(renderRequest) %>"
				url="<%= addArticleURL.toString() %>"
			/>

	<%
		}
	}
	%>

</liferay-ui:icon-menu>

<%!
public PortletURL getAddArticleURL(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, String structureId) throws Exception {
	PortletURL addArticleURL = liferayPortletResponse.createRenderURL();

	addArticleURL.setWindowState(LiferayWindowState.MAXIMIZED);

	addArticleURL.setParameter("struts_action", "/journal/edit_article");

	String currentURL = PortalUtil.getCurrentURL(liferayPortletRequest);

	addArticleURL.setParameter("redirect", currentURL);
	addArticleURL.setParameter("backURL", currentURL);

	if (Validator.isNotNull(structureId)) {
		addArticleURL.setParameter("structureId", structureId);
	}

	return addArticleURL;
}

public Map<String, PortletURL> getAddArticleURLs(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) throws Exception {
	ThemeDisplay themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

	Map<String, PortletURL> addArticleURLs = new TreeMap<String, PortletURL>();

	List<JournalStructure> structures = new ArrayList<JournalStructure>();

	structures.addAll(JournalStructureServiceUtil.getStructures(themeDisplay.getScopeGroupId()));

	if (themeDisplay.getCompanyGroupId() != themeDisplay.getScopeGroupId()) {
		structures.addAll(JournalStructureServiceUtil.getStructures(themeDisplay.getCompanyGroupId()));
	}

	PortletURL addArticleURL = getAddArticleURL(liferayPortletRequest, liferayPortletResponse, null);

	addArticleURLs.put(JournalArticle.class.getName(), addArticleURL);

	for (JournalStructure structure : structures) {
		addArticleURL = getAddArticleURL(liferayPortletRequest, liferayPortletResponse, structure.getStructureId());

		if (addArticleURL != null) {
			String structureName = structure.getName(themeDisplay.getLocale());

			if (structure.getGroupId() == themeDisplay.getCompanyGroupId()) {
				structureName += " (" + LanguageUtil.get(themeDisplay.getLocale(), "global") + ")";
			}

			addArticleURLs.put(JournalArticle.class.getName() + _CLASSNAME_SEPARATOR + HtmlUtil.escape(structureName), addArticleURL);
		}
	}

	return addArticleURLs;
}

private static final String _CLASSNAME_SEPARATOR = "_CLASSNAME_";
%>