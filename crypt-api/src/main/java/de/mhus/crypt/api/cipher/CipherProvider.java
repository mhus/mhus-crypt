/**
 * Copyright (C) 2019 Mike Hummel (mh@mhus.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.mhus.crypt.api.cipher;

import de.mhus.lib.core.IProperties;
import de.mhus.lib.core.crypt.pem.PemBlock;
import de.mhus.lib.core.crypt.pem.PemPair;
import de.mhus.lib.core.crypt.pem.PemPriv;
import de.mhus.lib.core.crypt.pem.PemPub;
import de.mhus.lib.core.util.SecureString;
import de.mhus.lib.errors.MException;

public interface CipherProvider {

    /**
     * Encrypt content, return a string block.
     *
     * @param key
     * @param content
     * @param string
     * @return block with encoded content
     * @throws MException
     */
    PemBlock encrypt(PemPub key, String content) throws MException;

    String decrypt(PemPriv key, PemBlock encoded, String passphrase) throws MException;

    default String decrypt(PemPriv key, PemBlock encoded, SecureString passphrase)
            throws MException {
        return decrypt(key, encoded, passphrase == null ? null : passphrase.value());
    };

    default String decrypt(PemPriv key, PemBlock encoded) throws MException {
        return decrypt(key, encoded, (String) null);
    };

    String getName();

    PemPair createKeys(IProperties properties) throws MException;
}
