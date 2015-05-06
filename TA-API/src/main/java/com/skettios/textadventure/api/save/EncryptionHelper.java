package com.skettios.textadventure.api.save;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class EncryptionHelper
{
	private static String SAVE_DES_KEY = "83DE42FA1F3C99AB";

	public static void encryptSave(InputStream is, OutputStream os)
	{
		doDecryptEncrypt(SAVE_DES_KEY, Cipher.ENCRYPT_MODE, is, os);
	}

	public static void decryptSave(InputStream is, OutputStream os)
	{
		doDecryptEncrypt(SAVE_DES_KEY, Cipher.DECRYPT_MODE, is, os);
	}

	public static void doDecryptEncrypt(String key, int mode, InputStream is, OutputStream os)
	{
		try
		{
			DESKeySpec dks = new DESKeySpec(key.getBytes());
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			SecretKey desKey = skf.generateSecret(dks);
			Cipher cipher = Cipher.getInstance("DES");

			if (mode == Cipher.ENCRYPT_MODE)
			{
				cipher.init(Cipher.ENCRYPT_MODE, desKey);
				CipherInputStream cis = new CipherInputStream(is, cipher);
				doCopy(cis, os);
			} else if (mode == Cipher.DECRYPT_MODE)
			{
				cipher.init(Cipher.DECRYPT_MODE, desKey);
				CipherOutputStream cos = new CipherOutputStream(os, cipher);
				doCopy(is, cos);
			}
		}
		catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}
		catch (InvalidKeySpecException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchPaddingException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}

	private static void doCopy(InputStream is, OutputStream os)
	{
		try
		{
			byte[] bytes = new byte[64];
			int numBytes;
			while ((numBytes = is.read(bytes)) != -1)
				os.write(bytes, 0, numBytes);

			os.flush();
			os.close();
			is.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
