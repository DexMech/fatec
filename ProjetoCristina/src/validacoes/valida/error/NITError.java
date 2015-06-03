package validacoes.valida.error;

import validacoes.valida.InvalidValue;

/**
 * Representa possíveis erros da validação do PIS
 * 
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
public enum NITError implements InvalidValue {
    INVALID_CHECK_DIGITS, INVALID_DIGITS, REPEATED_DIGITS, INVALID_FORMAT
}
