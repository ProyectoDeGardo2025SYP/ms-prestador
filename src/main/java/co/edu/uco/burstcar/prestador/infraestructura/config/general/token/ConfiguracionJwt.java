package co.edu.uco.burstcar.prestador.infraestructura.config.general.token;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

@Configuration
public class ConfiguracionJwt {

    private final PropiedadesConfiguracionJwt propiedades;

    public ConfiguracionJwt(PropiedadesConfiguracionJwt propiedades) {
        this.propiedades = propiedades;
    }

    public KeyPair obtenerLlave() {
        try {
            KeyStore almacenajeLlave = KeyStore.getInstance("JKS");
            InputStream almacenajeLlaveTexto = new ClassPathResource(propiedades.getAlmacenajeLocalizacion()).getInputStream();
            almacenajeLlave.load(almacenajeLlaveTexto, propiedades.getAlmacenajeContrasena().toCharArray());
            Key llave = almacenajeLlave.getKey(propiedades.getLlaveAlias(), propiedades.getLlaveContrasena().toCharArray());

            if (llave instanceof PrivateKey) {
                Certificate certificado = almacenajeLlave.getCertificate(propiedades.getLlaveAlias());
                PublicKey llavePublica = certificado.getPublicKey();
                return new KeyPair(llavePublica, (PrivateKey) llave);
            }
            throw new RuntimeException("No se pudo obtener la llave del keystore");
        } catch (Exception e) {
            throw new RuntimeException("Error cargando el KeyStore", e);
        }
    }
}
