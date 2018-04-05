package pl.dn.service.jwt.common;

import org.springframework.stereotype.Component;

@Component
public interface TokenExtractor {
	public String extract(String payload);
}
