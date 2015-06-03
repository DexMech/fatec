package validacoes.valida.error;

import validacoes.valida.InvalidValue;

/**
 * 
 * Representa possíveis erros do CNPJ
 * 
 * @author Leonardo Bessa
 * @author Fabio Kung
 */
public enum CNPJError implements InvalidValue {
    INVALID_CHECK_DIGITS, INVALID_DIGITS, INVALID_FORMAT
}
