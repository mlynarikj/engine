/*
 * Lumeer: Modern Data Definition and Processing Platform
 *
 * Copyright (C) since 2017 Answer Institute, s.r.o. and/or its affiliates.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.lumeer.storage.api.dao;

import io.lumeer.api.model.LinkType;
import io.lumeer.api.model.Project;
import io.lumeer.storage.api.query.SearchQuery;
import io.lumeer.storage.api.query.SuggestionQuery;

import java.util.List;

public interface LinkTypeDao {

   void createLinkTypeRepository(Project project);

   void deleteLinkTypeRepository(Project project);

   void setProject(Project project);

   LinkType createLinkType(LinkType linkType);

   LinkType updateLinkType(String id, LinkType linkType);

   void deleteLinkType(String id);

   void deleteLinkTypes(SearchQuery query);

   LinkType getLinkType(String id);

   List<LinkType> getLinkTypes(SearchQuery query);

   List<LinkType> getLinkTypes(SuggestionQuery query);

}
