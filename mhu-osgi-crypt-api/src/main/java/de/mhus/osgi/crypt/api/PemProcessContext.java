package de.mhus.osgi.crypt.api;

import de.mhus.lib.core.crypt.pem.PemBlock;
import de.mhus.lib.core.crypt.pem.PemPriv;
import de.mhus.lib.core.crypt.pem.PemPub;
import de.mhus.lib.core.util.SecureString;
import de.mhus.lib.errors.MException;

public interface PemProcessContext {

	void errorKeyNotFound(PemBlock block) throws CryptException;

	PemPriv getPrivateKey(String privId) throws MException;

	String getPrivateIdForPublicKeyId(String pubId) throws CryptException;

	SecureString getPassphrase(String privId, PemBlock block) throws CryptException;

	void foundSecret(PemBlock block, SecureString sec);

	void foundPublicKey(PemBlock block);

	void foundPrivateKey(PemBlock block);

	PemPub getPublicKey(String keyId);

	void foundHash(PemBlock block);

	void foundValidated(PemBlock block);
	
}