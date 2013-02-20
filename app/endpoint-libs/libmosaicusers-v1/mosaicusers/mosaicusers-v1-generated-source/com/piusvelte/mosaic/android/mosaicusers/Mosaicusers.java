/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This file was generated.
 *  with google-apis-code-generator 1.2.0 (build: 2013-02-14 15:45:00 UTC)
 *  on 2013-02-19 at 01:58:08 UTC 
 */

package com.piusvelte.mosaic.android.mosaicusers;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.common.base.Preconditions;

/**
 * Service definition for Mosaicusers (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link MosaicusersRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * <p>
 * Upgrade warning: this class now extends {@link AbstractGoogleJsonClient}, whereas in prior
 * version 1.8 it extended {@link com.google.api.client.googleapis.services.GoogleClient}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Mosaicusers extends AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    Preconditions.checkState(GoogleUtils.VERSION.equals("1.13.2-beta"),
        "You are currently running with version %s of google-api-client. " +
        "You need version 1.13.2-beta of google-api-client to run version " +
        "1.13.2-beta of the  library.", GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://mosaic-messaging.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "mosaicusers/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   * @deprecated (scheduled to be removed in 1.13)
   */
  @Deprecated
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport
   * @param jsonFactory JSON factory
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Mosaicusers(HttpTransport transport, JsonFactory jsonFactory,
      HttpRequestInitializer httpRequestInitializer) {
    super(transport,
        jsonFactory,
        DEFAULT_ROOT_URL,
        DEFAULT_SERVICE_PATH,
        httpRequestInitializer,
        false);
  }

  /**
   * @param transport HTTP transport
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @param rootUrl root URL of the service
   * @param servicePath service path
   * @param jsonObjectParser JSON object parser
   * @param googleClientRequestInitializer Google request initializer or {@code null} for none
   * @param applicationName application name to be sent in the User-Agent header of requests or
   *        {@code null} for none
   * @param suppressPatternChecks whether discovery pattern checks should be suppressed on required
   *        parameters
   */
  Mosaicusers(HttpTransport transport,
      HttpRequestInitializer httpRequestInitializer,
      String rootUrl,
      String servicePath,
      JsonObjectParser jsonObjectParser,
      GoogleClientRequestInitializer googleClientRequestInitializer,
      String applicationName,
      boolean suppressPatternChecks) {
    super(transport,
        httpRequestInitializer,
        rootUrl,
        servicePath,
        jsonObjectParser,
        googleClientRequestInitializer,
        applicationName,
        suppressPatternChecks);
  }

  @Override
  protected void initialize(AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getMosaicUser".
   *
   * This request holds the parameters needed by the the mosaicusers server.  After setting any
   * optional parameters, call the {@link GetMosaicUser#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetMosaicUser getMosaicUser(java.lang.String id) throws java.io.IOException {
    GetMosaicUser result = new GetMosaicUser(id);
    initialize(result);
    return result;
  }

  public class GetMosaicUser extends MosaicusersRequest<com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser> {

    private static final String REST_PATH = "mosaicuser/{id}";

    /**
     * Create a request for the method "getMosaicUser".
     *
     * This request holds the parameters needed by the the mosaicusers server.  After setting any
     * optional parameters, call the {@link GetMosaicUser#execute()} method to invoke the remote
     * operation. <p> {@link GetMosaicUser#initialize(AbstractGoogleClientRequest)} must be called to
     * initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetMosaicUser(java.lang.String id) {
      super(Mosaicusers.this, "GET", REST_PATH, null, com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser.class);
      this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetMosaicUser setAlt(java.lang.String alt) {
      return (GetMosaicUser) super.setAlt(alt);
    }

    @Override
    public GetMosaicUser setFields(java.lang.String fields) {
      return (GetMosaicUser) super.setFields(fields);
    }

    @Override
    public GetMosaicUser setKey(java.lang.String key) {
      return (GetMosaicUser) super.setKey(key);
    }

    @Override
    public GetMosaicUser setOauthToken(java.lang.String oauthToken) {
      return (GetMosaicUser) super.setOauthToken(oauthToken);
    }

    @Override
    public GetMosaicUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetMosaicUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetMosaicUser setQuotaUser(java.lang.String quotaUser) {
      return (GetMosaicUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetMosaicUser setUserIp(java.lang.String userIp) {
      return (GetMosaicUser) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetMosaicUser setId(java.lang.String id) {
      this.id = id;
      return this;
    }

  }

  /**
   * Create a request for the method "insertMosaicUser".
   *
   * This request holds the parameters needed by the the mosaicusers server.  After setting any
   * optional parameters, call the {@link InsertMosaicUser#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser}
   * @return the request
   */
  public InsertMosaicUser insertMosaicUser(com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser content) throws java.io.IOException {
    InsertMosaicUser result = new InsertMosaicUser(content);
    initialize(result);
    return result;
  }

  public class InsertMosaicUser extends MosaicusersRequest<com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser> {

    private static final String REST_PATH = "mosaicuser";

    /**
     * Create a request for the method "insertMosaicUser".
     *
     * This request holds the parameters needed by the the mosaicusers server.  After setting any
     * optional parameters, call the {@link InsertMosaicUser#execute()} method to invoke the remote
     * operation. <p> {@link InsertMosaicUser#initialize(AbstractGoogleClientRequest)} must be called
     * to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser}
     * @since 1.13
     */
    protected InsertMosaicUser(com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser content) {
      super(Mosaicusers.this, "POST", REST_PATH, content, com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser.class);
    }

    @Override
    public InsertMosaicUser setAlt(java.lang.String alt) {
      return (InsertMosaicUser) super.setAlt(alt);
    }

    @Override
    public InsertMosaicUser setFields(java.lang.String fields) {
      return (InsertMosaicUser) super.setFields(fields);
    }

    @Override
    public InsertMosaicUser setKey(java.lang.String key) {
      return (InsertMosaicUser) super.setKey(key);
    }

    @Override
    public InsertMosaicUser setOauthToken(java.lang.String oauthToken) {
      return (InsertMosaicUser) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertMosaicUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertMosaicUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertMosaicUser setQuotaUser(java.lang.String quotaUser) {
      return (InsertMosaicUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertMosaicUser setUserIp(java.lang.String userIp) {
      return (InsertMosaicUser) super.setUserIp(userIp);
    }

  }

  /**
   * Create a request for the method "listMosaicUser".
   *
   * This request holds the parameters needed by the the mosaicusers server.  After setting any
   * optional parameters, call the {@link ListMosaicUser#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListMosaicUser listMosaicUser() throws java.io.IOException {
    ListMosaicUser result = new ListMosaicUser();
    initialize(result);
    return result;
  }

  public class ListMosaicUser extends MosaicusersRequest<com.piusvelte.mosaic.android.mosaicusers.model.MosaicUserCollection> {

    private static final String REST_PATH = "mosaicuser";

    /**
     * Create a request for the method "listMosaicUser".
     *
     * This request holds the parameters needed by the the mosaicusers server.  After setting any
     * optional parameters, call the {@link ListMosaicUser#execute()} method to invoke the remote
     * operation. <p> {@link ListMosaicUser#initialize(AbstractGoogleClientRequest)} must be called to
     * initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListMosaicUser() {
      super(Mosaicusers.this, "GET", REST_PATH, null, com.piusvelte.mosaic.android.mosaicusers.model.MosaicUserCollection.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListMosaicUser setAlt(java.lang.String alt) {
      return (ListMosaicUser) super.setAlt(alt);
    }

    @Override
    public ListMosaicUser setFields(java.lang.String fields) {
      return (ListMosaicUser) super.setFields(fields);
    }

    @Override
    public ListMosaicUser setKey(java.lang.String key) {
      return (ListMosaicUser) super.setKey(key);
    }

    @Override
    public ListMosaicUser setOauthToken(java.lang.String oauthToken) {
      return (ListMosaicUser) super.setOauthToken(oauthToken);
    }

    @Override
    public ListMosaicUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListMosaicUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListMosaicUser setQuotaUser(java.lang.String quotaUser) {
      return (ListMosaicUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListMosaicUser setUserIp(java.lang.String userIp) {
      return (ListMosaicUser) super.setUserIp(userIp);
    }

  }

  /**
   * Create a request for the method "removeMosaicUser".
   *
   * This request holds the parameters needed by the the mosaicusers server.  After setting any
   * optional parameters, call the {@link RemoveMosaicUser#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveMosaicUser removeMosaicUser(java.lang.String id) throws java.io.IOException {
    RemoveMosaicUser result = new RemoveMosaicUser(id);
    initialize(result);
    return result;
  }

  public class RemoveMosaicUser extends MosaicusersRequest<com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser> {

    private static final String REST_PATH = "mosaicuser/{id}";

    /**
     * Create a request for the method "removeMosaicUser".
     *
     * This request holds the parameters needed by the the mosaicusers server.  After setting any
     * optional parameters, call the {@link RemoveMosaicUser#execute()} method to invoke the remote
     * operation. <p> {@link RemoveMosaicUser#initialize(AbstractGoogleClientRequest)} must be called
     * to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveMosaicUser(java.lang.String id) {
      super(Mosaicusers.this, "DELETE", REST_PATH, null, com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser.class);
      this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveMosaicUser setAlt(java.lang.String alt) {
      return (RemoveMosaicUser) super.setAlt(alt);
    }

    @Override
    public RemoveMosaicUser setFields(java.lang.String fields) {
      return (RemoveMosaicUser) super.setFields(fields);
    }

    @Override
    public RemoveMosaicUser setKey(java.lang.String key) {
      return (RemoveMosaicUser) super.setKey(key);
    }

    @Override
    public RemoveMosaicUser setOauthToken(java.lang.String oauthToken) {
      return (RemoveMosaicUser) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveMosaicUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveMosaicUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveMosaicUser setQuotaUser(java.lang.String quotaUser) {
      return (RemoveMosaicUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveMosaicUser setUserIp(java.lang.String userIp) {
      return (RemoveMosaicUser) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public RemoveMosaicUser setId(java.lang.String id) {
      this.id = id;
      return this;
    }

  }

  /**
   * Create a request for the method "updateMosaicUser".
   *
   * This request holds the parameters needed by the the mosaicusers server.  After setting any
   * optional parameters, call the {@link UpdateMosaicUser#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser}
   * @return the request
   */
  public UpdateMosaicUser updateMosaicUser(com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser content) throws java.io.IOException {
    UpdateMosaicUser result = new UpdateMosaicUser(content);
    initialize(result);
    return result;
  }

  public class UpdateMosaicUser extends MosaicusersRequest<com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser> {

    private static final String REST_PATH = "mosaicuser";

    /**
     * Create a request for the method "updateMosaicUser".
     *
     * This request holds the parameters needed by the the mosaicusers server.  After setting any
     * optional parameters, call the {@link UpdateMosaicUser#execute()} method to invoke the remote
     * operation. <p> {@link UpdateMosaicUser#initialize(AbstractGoogleClientRequest)} must be called
     * to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser}
     * @since 1.13
     */
    protected UpdateMosaicUser(com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser content) {
      super(Mosaicusers.this, "PUT", REST_PATH, content, com.piusvelte.mosaic.android.mosaicusers.model.MosaicUser.class);
    }

    @Override
    public UpdateMosaicUser setAlt(java.lang.String alt) {
      return (UpdateMosaicUser) super.setAlt(alt);
    }

    @Override
    public UpdateMosaicUser setFields(java.lang.String fields) {
      return (UpdateMosaicUser) super.setFields(fields);
    }

    @Override
    public UpdateMosaicUser setKey(java.lang.String key) {
      return (UpdateMosaicUser) super.setKey(key);
    }

    @Override
    public UpdateMosaicUser setOauthToken(java.lang.String oauthToken) {
      return (UpdateMosaicUser) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateMosaicUser setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateMosaicUser) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateMosaicUser setQuotaUser(java.lang.String quotaUser) {
      return (UpdateMosaicUser) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateMosaicUser setUserIp(java.lang.String userIp) {
      return (UpdateMosaicUser) super.setUserIp(userIp);
    }

  }

  /**
   * Builder for {@link Mosaicusers}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport
     * @param jsonFactory JSON factory
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(HttpTransport transport, JsonFactory jsonFactory,
        HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Mosaicusers}. */
    @Override
    public Mosaicusers build() {
      return new Mosaicusers(getTransport(),
          getHttpRequestInitializer(),
          getRootUrl(),
          getServicePath(),
          getObjectParser(),
          getGoogleClientRequestInitializer(),
          getApplicationName(),
          getSuppressPatternChecks());
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    /**
     * Set the {@link MosaicusersRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setMosaicusersRequestInitializer(
        MosaicusersRequestInitializer mosaicusersRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(mosaicusersRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
