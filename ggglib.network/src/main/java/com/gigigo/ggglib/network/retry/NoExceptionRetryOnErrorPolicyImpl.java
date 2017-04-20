package com.gigigo.ggglib.network.retry;

import com.gigigo.ggglib.network.defaultelements.RetryOnErrorPolicy;
import com.gigigo.ggglib.network.retrofit.context.responses.ApiGenericResponse;
import com.gigigo.ggglib.network.retrofit.context.responses.HttpResponse;

public class NoExceptionRetryOnErrorPolicyImpl implements RetryOnErrorPolicy<ApiGenericResponse> {

  /**
   * The aim of this method is implement the desired policy and implement a switch case strategy
   * that depending on the error Type (Http / Business or whatever) could allow us to decide if
   * we want to retry the request or not
   *
   * @param tries time the request has been already retried
   * @param error error description
   * @param httpResponse full http response of error
   */
  @Override public boolean shouldRetryWithErrorAndTries(int tries, ApiGenericResponse error,
      HttpResponse httpResponse) {
    if (tries < 3) {
      return true;
    } else {
      return false;
    }
  }

  @Override public boolean shouldRetryOnException(int tries, Exception e) {
    if (tries < 3) {
      return true;
    } else {
      return false;
    }
  }
}