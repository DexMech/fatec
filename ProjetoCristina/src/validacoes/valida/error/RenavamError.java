package validacoes.valida.error;

import validacoes.valida.InvalidValue;

/**
 * Representa possíveis erros na validação do Renavam
 * 
 * @author Rafael Carvalho
 */
public enum RenavamError implements InvalidValue {

    INVALID_FORMAT, INVALID_CHECK_DIGIT, INVALID_DIGITS
}
