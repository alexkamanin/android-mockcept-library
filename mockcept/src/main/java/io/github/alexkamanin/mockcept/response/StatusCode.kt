package io.github.alexkamanin.mockcept.response

/**
 * A lot of responses from the server
 * @property code Response code which automatically return [Mockcept]
 */
enum class StatusCode(internal val code: Int) {

    /**
     * Codes starts with 1xx informational response – the request was received, continuing process
     */
    Continue(100),
    SwitchingProtocols(101),
    Processing(102),
    EarlyHints(103),

    /**
     * Codes starts with 2xx successful – the request was successfully received, understood, and accepted
     */
    OK(200),
    Created(201),
    Accepted(202),
    NonAuthoritativeInformation(203),
    NoContent(204),
    ResetContent(205),
    PartialContent(206),
    MultiStatus(207),
    AlreadyReported(208),
    ImUsed(226),

    /**
     * Codes starts with 3xx redirection – further action needs to be taken in order to complete the request
     */
    MultipleChoices(300),
    MovedPermanently(301),
    Found(302),
    SeeOther(303),
    NotModified(304),
    UseProxy(305),
    TemporaryRedirect(307),
    PermanentRedirect(308),

    /**
     * Codes starts with 4xx client error – the request contains bad syntax or cannot be fulfilled
     */
    BadRequest(400),
    Unauthorized(401),
    PaymentRequired(402),
    Forbidden(403),
    NotFound(404),
    MethodNotAllowed(405),
    NotAcceptable(406),
    ProxyAuthenticationRequired(407),
    RequestTimeout(408),
    Conflict(409),
    Gone(410),
    LengthRequired(411),
    PreconditionFailed(412),
    PayloadTooLarge(413),
    UriTooLong(414),
    UnsupportedMediaType(415),
    RangeNotSatisfiable(416),
    ExpectationFailed(417),
    MisdirectedRequest(421),
    UnprocessableEntity(422),
    Locked(423),
    FailedDependency(424),
    TooEarly(425),
    UpgradeRequired(426),
    PreconditionRequired(428),
    TooManyRequests(429),
    RequestHeaderFieldsTooLarge(431),
    RetryWith(449),
    UnavailableForLegalReasons(451),
    ClientClosedRequest(499),

    /**
     * Codes starts with 5xx server error – the server failed to fulfil an apparently valid request
     */
    InternalServerError(500),
    NotImplemented(501),
    BadGateway(502),
    ServiceUnavailable(503),
    GatewayTimeout(504),
    HttpVersionNotSupported(505),
    VariantAlsoNegotiates(506),
    InsufficientStorage(507),
    LoopDetected(508),
    BandwidthLimitExceeded(509),
    NotExtended(510),
    NetworkAuthenticationRequired(511),
    UnknownError(520),
    WebServerIsDown(521),
    ConnectionTimedOut(522),
    OriginIsUnreachable(523),
    TimeoutOccurred(524),
    SslHandshakeFailed(525),
    InvalidSslCertificate(526),
}