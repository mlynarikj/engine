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
package io.lumeer.engine.provider;

import io.lumeer.engine.api.cache.Cache;
import io.lumeer.engine.api.cache.CacheManager;
import io.lumeer.engine.api.cache.CacheProvider;

import java.io.Serializable;

/**
 * @author <a href="mailto:marvenec@gmail.com">Martin Večeřa</a>
 */
public class DefaultCacheProvider implements CacheProvider, Serializable {

   private String namespace;

   private CacheManager cacheManager;

   public void init(final String namespace, final CacheManager cacheManager) {
      this.namespace = namespace;
      this.cacheManager = cacheManager;
   }

   @Override
   public <T> Cache<T> getCache(final String cacheName) {
      return cacheManager.getCache(namespace + "/" + cacheName);
   }
}
