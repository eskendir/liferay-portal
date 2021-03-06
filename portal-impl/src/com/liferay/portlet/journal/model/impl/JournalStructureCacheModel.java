/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.journal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.portlet.journal.model.JournalStructure;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JournalStructure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see JournalStructure
 * @generated
 */
public class JournalStructureCacheModel implements CacheModel<JournalStructure>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", structureId=");
		sb.append(structureId);
		sb.append(", parentStructureId=");
		sb.append(parentStructureId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", xsd=");
		sb.append(xsd);
		sb.append("}");

		return sb.toString();
	}

	public JournalStructure toEntityModel() {
		JournalStructureImpl journalStructureImpl = new JournalStructureImpl();

		if (uuid == null) {
			journalStructureImpl.setUuid(StringPool.BLANK);
		}
		else {
			journalStructureImpl.setUuid(uuid);
		}

		journalStructureImpl.setId(id);
		journalStructureImpl.setGroupId(groupId);
		journalStructureImpl.setCompanyId(companyId);
		journalStructureImpl.setUserId(userId);

		if (userName == null) {
			journalStructureImpl.setUserName(StringPool.BLANK);
		}
		else {
			journalStructureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			journalStructureImpl.setCreateDate(null);
		}
		else {
			journalStructureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			journalStructureImpl.setModifiedDate(null);
		}
		else {
			journalStructureImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (structureId == null) {
			journalStructureImpl.setStructureId(StringPool.BLANK);
		}
		else {
			journalStructureImpl.setStructureId(structureId);
		}

		if (parentStructureId == null) {
			journalStructureImpl.setParentStructureId(StringPool.BLANK);
		}
		else {
			journalStructureImpl.setParentStructureId(parentStructureId);
		}

		if (name == null) {
			journalStructureImpl.setName(StringPool.BLANK);
		}
		else {
			journalStructureImpl.setName(name);
		}

		if (description == null) {
			journalStructureImpl.setDescription(StringPool.BLANK);
		}
		else {
			journalStructureImpl.setDescription(description);
		}

		if (xsd == null) {
			journalStructureImpl.setXsd(StringPool.BLANK);
		}
		else {
			journalStructureImpl.setXsd(xsd);
		}

		journalStructureImpl.resetOriginalValues();

		return journalStructureImpl;
	}

	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		id = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		structureId = objectInput.readUTF();
		parentStructureId = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		xsd = objectInput.readUTF();
	}

	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (structureId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(structureId);
		}

		if (parentStructureId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(parentStructureId);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (xsd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xsd);
		}
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String structureId;
	public String parentStructureId;
	public String name;
	public String description;
	public String xsd;
}