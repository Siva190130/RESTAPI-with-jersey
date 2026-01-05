<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Jersey REST API – Overview</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
          
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
      rel="stylesheet">
      
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
      

    <!-- Optional small custom CSS -->
    <link rel="stylesheet"
          href="<%= request.getContextPath() %>/resources/css/custom.css">
</head>

<body class="bg-light">

<!-- ================= HERO HEADER ================= -->
<div class="container-fluid hero-header">
  <div class="container py-5">
    <div class="row align-items-center">

      <!-- LEFT CONTENT -->
      <div class="col-md-7">

        <span class="badge bg-primary-subtle text-primary mb-3 px-3 py-2">
          REST API · JAX-RS · Jersey
        </span>

        <h1 class="display-4 fw-bold mt-3 mb-3 hero-title">
          Enterprise RESTful<br>
          Web Application
        </h1>

        <p class="lead text-muted mb-4">
          A production-ready REST API built with
          <strong>JAX-RS (Jersey)</strong>, designed around
          HTTP semantics, stateless architecture, and clean resource modeling.
        </p>

        <div class="d-flex align-items-center gap-3">
          <a href="<%= request.getContextPath() %>/webapi/myresource"
             class="btn btn-primary btn-lg px-4">
            Explore API
          </a>

          <span class="text-muted small">
            Designed and implemented by <strong>Shiva</strong>
          </span>
        </div>

        <div class="mt-4 text-muted small">
          Associate Software Engineer · Achala IT Solutions
        </div>

      </div>

      <!-- RIGHT IMAGE -->
      <div class="col-md-5 text-center position-relative">

        <div class="profile-ring">
          <img src="<%= request.getContextPath() %>/resources/images/Siva.JPG"
               class="rounded-circle shadow hero-profile">
        </div>

      </div>

    </div>
  </div>
</div>

<hr>


		
				<!-- ================= ANIMATED VISUAL CAROUSEL ================= -->
<div class="container py-5 mb-5">
  <h2 class="fw-bold text-center mb-5">
    How REST APIs Work – Visually
  </h2>

  <div id="restVisualCarousel"
       class="carousel slide carousel-fade"
       data-bs-ride="false">

    <!-- INDICATORS -->
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#restVisualCarousel" data-bs-slide-to="0"
              class="active" aria-current="true"></button>
      <button type="button" data-bs-target="#restVisualCarousel" data-bs-slide-to="1"></button>
      <button type="button" data-bs-target="#restVisualCarousel" data-bs-slide-to="2"></button>
      <button type="button" data-bs-target="#restVisualCarousel" data-bs-slide-to="3"></button>
      <button type="button" data-bs-target="#restVisualCarousel" data-bs-slide-to="4"></button>
    </div>

    <!-- SLIDES -->
    <div class="carousel-inner rounded shadow-sm">

      <!-- Slide 1 -->
      <div class="carousel-item active">
        <img src="<%= request.getContextPath() %>/resources/images/rest-basics.jpg"
             class="d-block w-100 carousel-img zoomable"
             data-bs-toggle="modal"
             data-bs-target="#imageZoomModal">
        <div class="carousel-caption d-none d-md-block">
          <h5>REST Basics</h5>
          <p>Core concepts before implementation</p>
        </div>
      </div>

      <!-- Slide 2 -->
      <div class="carousel-item">
        <img src="<%= request.getContextPath() %>/resources/images/restmodel.png"
             class="d-block w-100 carousel-img zoomable"
             data-bs-toggle="modal"
             data-bs-target="#imageZoomModal">
        <div class="carousel-caption d-none d-md-block">
          <h5>REST API Flow</h5>
          <p>Client → API → Server → Response</p>
        </div>
      </div>

      <!-- Slide 3 -->
      <div class="carousel-item">
        <img src="<%= request.getContextPath() %>/resources/images/REST-Roadmap.png"
             class="d-block w-100 carousel-img zoomable"
             data-bs-toggle="modal"
             data-bs-target="#imageZoomModal">
        <div class="carousel-caption d-none d-md-block">
          <h5>API Learning Roadmap</h5>
          <p>From basics to gateways and scaling</p>
        </div>
      </div>

      <!-- Slide 4 -->
      <div class="carousel-item">
        <img src="<%= request.getContextPath() %>/resources/images/statelessness.png"
             class="d-block w-100 carousel-img zoomable"
             data-bs-toggle="modal"
             data-bs-target="#imageZoomModal">
        <div class="carousel-caption d-none d-md-block">
          <h5>Stateless Architecture</h5>
          <p>Every request is independent</p>
        </div>
      </div>

      <!-- Slide 5 -->
      <div class="carousel-item">
        <img src="<%= request.getContextPath() %>/resources/images/http-status-codes.png"
             class="d-block w-100 carousel-img zoomable"
             data-bs-toggle="modal"
             data-bs-target="#imageZoomModal">
        <div class="carousel-caption d-none d-md-block">
          <h5>HTTP Status Semantics</h5>
          <p>Clear, meaningful client–server communication</p>
        </div>
      </div>

    </div>

    <!-- CONTROLS -->
    <button class="carousel-control-prev" type="button"
            data-bs-target="#restVisualCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon"></span>
    </button>

    <button class="carousel-control-next" type="button"
            data-bs-target="#restVisualCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon"></span>
    </button>

  </div>
</div>

	<!-- ================= REST FLOW ANIMATION ================= -->
			<div class="container py-5">
			  <h2 class="fw-bold text-center mb-4">
			    REST Request–Response Lifecycle
			  </h2>
			
			  <div class="rest-flow d-flex justify-content-center align-items-center">
			
			    <div class="flow-box">
			      <i class="bi bi-laptop"></i>
			      <span>Client</span>
			    </div>
			
			    <div class="flow-arrow">➜</div>
			
			    <div class="flow-box delay-1">
			      <i class="bi bi-cloud"></i>
			      <span>REST API</span>
			    </div>
			
			    <div class="flow-arrow">➜</div>
			
			    <div class="flow-box delay-2">
			      <i class="bi bi-database"></i>
			      <span>Database</span>
			    </div>
			
			    <div class="flow-arrow back">⟵ Response</div>
			
			  </div>
			</div>
				
	
<!-- ================= IMPLEMENTED ================= -->
			<div class="container py-5">
			  <h2 class="fw-bold mb-4">Implemented Capabilities</h2>
			
			  <div class="row g-4">
			
			    <div class="col-md-3">
					  <div class="card h-100 shadow-sm border-0 text-center p-3 hover-card"
					       data-bs-toggle="collapse"
					       data-bs-target="#restfulDesignContent"
					       role="button"
					       aria-expanded="false"
					       style="cursor:pointer;">
					
					    <i class="bi bi-diagram-3-fill fs-1 text-primary mb-3"></i>
					    <h6 class="fw-semibold">RESTful Design</h6>
					    <p class="text-muted small">Resource-oriented API structure</p>
					
					    <small class="text-primary">Click to read</small>
					  </div>
				</div>

			
			    <div class="col-md-3">
					  <div class="card h-100 shadow-sm border-0 text-center p-3 hover-card"
					       data-bs-toggle="collapse"
					       data-bs-target="#crudSemanticsContent"
					       role="button"
					       aria-expanded="false"
					       style="cursor:pointer;">
					
					    <i class="bi bi-arrow-left-right fs-1 text-success mb-3"></i>
					    <h6 class="fw-semibold">HTTP Methods</h6>
					    <p class="text-muted small">GET, POST, PUT, PATCH, DELETE</p>
					
					    <small class="text-success">Click to view CRUD</small>
					  </div>
			  </div>

			
			   <div class="col-md-3">
					  <div class="card h-100 shadow-sm border-0 text-center p-3 hover-card"
					       data-bs-toggle="collapse"
					       data-bs-target="#httpStatusContent"
					       role="button"
					       aria-expanded="false"
					       style="cursor:pointer;">
					
					    <i class="bi bi-check2-circle fs-1 text-info mb-3"></i>
					    <h6 class="fw-semibold">Status Codes</h6>
					    <p class="text-muted small">Semantic HTTP responses</p>
					
					    <small class="text-info">Click to explore</small>
					  </div>
				</div>

			
			   <div class="col-md-3">
			  <div class="card h-100 shadow-sm border-0 text-center p-3 hover-card"
			       data-bs-toggle="collapse"
			       data-bs-target="#exceptionHandlingSection"
			       role="button"
			       aria-expanded="false"
			       style="cursor:pointer;">
			
			    <i class="bi bi-exclamation-triangle-fill fs-1 text-danger mb-3"></i>
			    <h6 class="fw-semibold">Error Handling</h6>
			    <p class="text-muted small">Centralized exception mapping</p>
			
			    <small class="text-danger">Click to explore</small>
			  </div>
		</div>

			  </div>
			</div>
			
		
			
			
	<!-- ======== RESTFUL DESIGN – ENHANCED VISUAL CONTENT ======== -->
<div class="container mt-4">
  <div class="collapse" id="restfulDesignContent">
    <div class="card border-0 shadow-sm p-4 content-card">

      <h4 class="fw-bold mb-4 text-center">
        Resource-Oriented API Design
      </h4>

      <div class="row align-items-center g-4">

        <!-- LEFT: EXPLANATION -->
        <div class="col-md-6">

          <p>
            A <strong>RESTful API</strong> is built around the idea that
            <em>everything is a resource</em>.  
            URLs represent <strong>nouns</strong> (entities), not actions.
          </p>

          <p>
            Instead of encoding behavior in the URL, REST relies on
            <strong>HTTP methods</strong> to describe the operation.
          </p>

          <ul class="mt-3">
            <li>URLs identify <strong>what</strong> the resource is</li>
            <li>HTTP methods define <strong>what happens</strong></li>
            <li>Stateless interactions ensure scalability</li>
            <li>Uniform structure improves predictability</li>
          </ul>

        </div>

        <!-- RIGHT: VISUAL -->
        <div class="col-md-6 text-center">
          <img src="<%= request.getContextPath() %>/resources/images/rest-resource-design.png"
               class="img-fluid rounded shadow zoomable"
               style="max-height: 320px;"
               data-bs-toggle="modal"
               data-bs-target="#imageZoomModal"
               alt="REST Resource Oriented Design">
        </div>

      </div>

      <hr class="my-4">

      <!-- ENDPOINT SEMANTICS -->
      <h5 class="fw-semibold mb-3">Endpoint Semantics</h5>

      <p class="text-muted">
        Each resource is accessed using a stable URI and manipulated
        using standard HTTP verbs:
      </p>

      <pre class="code-block">
GET     /players                 → Retrieve all players
POST    /players                 → Create a new player
POST    /players/bulk            → Create a bulk of players
GET     /players/{id}            → Retrieve a specific player
GET     /players?name=virat      → Retrieve a specific player
PUT     /players/{id}            → Replace player data
PATCH   /players/{id}            → Partially update player
DELETE  /players/{id}            → Remove player
      </pre>

      <p class="mt-3">
        This separation of <strong>resource identity</strong> from
        <strong>behavior</strong> makes the API intuitive, scalable,
        and aligned with HTTP standards.
      </p>

    </div>
  </div>
</div>

					
<!-- ================= CRUD SEMANTICS – INTERACTIVE GUIDE ================= -->
<div class="container mt-4">
  <div class="collapse" id="crudSemanticsContent">
    <div class="container py-5">

      <h2 class="fw-bold text-center mb-4">
        CRUD Semantics – Postman Proof
      </h2>

      <p class="text-center text-muted mb-5">
        How each HTTP method maps to a RESTful operation,
        validated with real API calls
      </p>

      <div class="accordion shadow-sm" id="crudAccordion">

        <!-- GET -->
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button fw-semibold"
                    data-bs-toggle="collapse"
                    data-bs-target="#crudGet">
              GET – Retrieve Resources
            </button>
          </h2>

          <div id="crudGet" class="accordion-collapse collapse show"
               data-bs-parent="#crudAccordion">
            <div class="accordion-body row g-4 align-items-center">

              <div class="col-md-6 text-center">
                <img src="<%= request.getContextPath() %>/resources/images/crud/GET-ALL.png"
                     class="img-fluid rounded shadow zoomable"
                     data-bs-toggle="modal"
                     data-bs-target="#imageZoomModal">
              </div>

              <div class="col-md-6">
                <p>
                  <strong>GET</strong> is used to retrieve resources
                  without modifying server state.
                </p>
                <ul>
                  <li>Safe and idempotent</li>
                  <li>No request body</li>
                  <li>Returns <code>200 OK</code></li>
                </ul>

                <pre class="code-block">
GET /players
GET /players/{id}
GET /players?name=virat
                </pre>
              </div>

            </div>
          </div>
        </div>

        <!-- POST -->
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed fw-semibold"
                    data-bs-toggle="collapse"
                    data-bs-target="#crudPost">
              POST – Create Resources
            </button>
          </h2>

          <div id="crudPost" class="accordion-collapse collapse"
               data-bs-parent="#crudAccordion">
            <div class="accordion-body row g-4 align-items-center">

              <div class="col-md-6 text-center">
                <img src="<%= request.getContextPath() %>/resources/images/crud/POST-I.png"
                     class="img-fluid rounded shadow zoomable"
                     data-bs-toggle="modal"
                     data-bs-target="#imageZoomModal">
              </div>

              <div class="col-md-6">
                <p>
                  <strong>POST</strong> creates a new resource.
                </p>
                <ul>
                  <li>Not idempotent</li>
                  <li>Accepts request body</li>
                  <li>Returns <code>201 Created</code></li>
                </ul>

                <pre class="code-block">
POST /players
POST /players/bulk
                </pre>
              </div>

            </div>
          </div>
        </div>

        <!-- PUT -->
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed fw-semibold"
                    data-bs-toggle="collapse"
                    data-bs-target="#crudPut">
              PUT – Full Update
            </button>
          </h2>

          <div id="crudPut" class="accordion-collapse collapse"
               data-bs-parent="#crudAccordion">
            <div class="accordion-body row g-4 align-items-center">

              <div class="col-md-6 text-center">
                <img src="<%= request.getContextPath() %>/resources/images/crud/PUT.png"
                     class="img-fluid rounded shadow zoomable"
                     data-bs-toggle="modal"
                     data-bs-target="#imageZoomModal">
              </div>

              <div class="col-md-6">
                <p>
                  <strong>PUT</strong> replaces the entire resource.
                </p>
                <ul>
                  <li>Idempotent</li>
                  <li>Full object required</li>
                  <li>Returns <code>200 OK</code></li>
                </ul>

                <pre class="code-block">
PUT /players/{id}
                </pre>
              </div>

            </div>
          </div>
        </div>

        <!-- PATCH -->
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed fw-semibold"
                    data-bs-toggle="collapse"
                    data-bs-target="#crudPatch">
              PATCH – Partial Update
            </button>
          </h2>

          <div id="crudPatch" class="accordion-collapse collapse"
               data-bs-parent="#crudAccordion">
            <div class="accordion-body row g-4 align-items-center">

              <div class="col-md-6 text-center">
                <img src="<%= request.getContextPath() %>/resources/images/crud/PATCH.png"
                     class="img-fluid rounded shadow zoomable"
                     data-bs-toggle="modal"
                     data-bs-target="#imageZoomModal">
              </div>

              <div class="col-md-6">
                <p>
                  <strong>PATCH</strong> updates specific fields only.
                </p>
                <ul>
                  <li>Partial payload</li>
                  <li>Efficient updates</li>
                  <li>Returns <code>200 OK</code></li>
                </ul>

                <pre class="code-block">
PATCH /players/{id}
                </pre>
              </div>

            </div>
          </div>
        </div>

        <!-- DELETE -->
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed fw-semibold"
                    data-bs-toggle="collapse"
                    data-bs-target="#crudDelete">
              DELETE – Remove Resource
            </button>
          </h2>

          <div id="crudDelete" class="accordion-collapse collapse"
               data-bs-parent="#crudAccordion">
            <div class="accordion-body row g-4 align-items-center">

              <div class="col-md-6 text-center">
                <img src="<%= request.getContextPath() %>/resources/images/crud/DELETE.png"
                     class="img-fluid rounded shadow zoomable"
                     data-bs-toggle="modal"
                     data-bs-target="#imageZoomModal">
              </div>

              <div class="col-md-6">
                <p>
                  <strong>DELETE</strong> removes a resource permanently.
                </p>
                <ul>
                  <li>Idempotent</li>
                  <li>No response body</li>
                  <li>Returns <code>204 No Content</code></li>
                </ul>

                <pre class="code-block">
DELETE /players/{id}
                </pre>
              </div>

            </div>
          </div>
        </div>

      </div>

    </div>
  </div>
</div>

<!-- ================= HTTP STATUS CODES – INTERACTIVE GUIDE ================= -->
<div class="container mt-4">
  <div class="collapse" id="httpStatusContent">
    <div class="container py-5">

      <h2 class="fw-bold text-center mb-4">
        HTTP Status Codes – REST Semantics
      </h2>

      <p class="text-center text-muted mb-5">
        How REST APIs communicate success and failure
        using standardized HTTP response codes
      </p>

      <div class="accordion shadow-sm" id="statusCodeAccordion">

        <!-- WHY -->
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button fw-semibold"
                    data-bs-toggle="collapse"
                    data-bs-target="#statusWhy">
              Why HTTP Status Codes Matter
            </button>
          </h2>

          <div id="statusWhy"
               class="accordion-collapse collapse show"
               data-bs-parent="#statusCodeAccordion">
            <div class="accordion-body">

              <p>
                HTTP status codes are part of the <strong>API contract</strong>.
                They communicate the outcome of a request independently of
                the response body.
              </p>

              <ul>
                <li>Clients react based on status, not message text</li>
                <li>Improves predictability and debuggability</li>
                <li>Essential for frontend and automation tools</li>
              </ul>

            </div>
          </div>
        </div>

        <!-- 2XX -->
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed fw-semibold"
                    data-bs-toggle="collapse"
                    data-bs-target="#status2xx">
              Success Responses (2xx)
            </button>
          </h2>

          <div id="status2xx"
               class="accordion-collapse collapse"
               data-bs-parent="#statusCodeAccordion">
            <div class="accordion-body row g-4 align-items-center">

              <div class="col-md-6 text-center">
                <img src="<%= request.getContextPath() %>/resources/images/http-status-codes.png"
                     class="img-fluid rounded shadow zoomable"
                     data-bs-toggle="modal"
                     data-bs-target="#imageZoomModal"
                     alt="HTTP 2xx Status Codes">
              </div>

              <div class="col-md-6">
                <p>
                  <strong>2xx</strong> status codes indicate successful processing
                  of a request.
                </p>

                <pre class="code-block">
200 OK         → Successful GET, PUT, PATCH
201 Created    → Resource created
204 No Content → Successful DELETE
                </pre>
              </div>

            </div>
          </div>
        </div>

        <!-- 4XX -->
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed fw-semibold"
                    data-bs-toggle="collapse"
                    data-bs-target="#status4xx">
              Client Errors (4xx)
            </button>
          </h2>

          <div id="status4xx"
               class="accordion-collapse collapse"
               data-bs-parent="#statusCodeAccordion">
            <div class="accordion-body row g-4 align-items-center">

              <div class="col-md-6 text-center">
                <img src="<%= request.getContextPath() %>/resources/images/http-status-codes.png"
                     class="img-fluid rounded shadow zoomable"
                     data-bs-toggle="modal"
                     data-bs-target="#imageZoomModal"
                     alt="HTTP 4xx Status Codes">
              </div>

              <div class="col-md-6">
                <p>
                  <strong>4xx</strong> responses indicate problems with
                  the client request.
                </p>

                <pre class="code-block">
400 Bad Request  → Invalid input
401 Unauthorized → Authentication required
403 Forbidden    → Access denied
404 Not Found    → Resource missing
409 Conflict     → Duplicate data
                </pre>
              </div>

            </div>
          </div>
        </div>

        <!-- 5XX -->
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button collapsed fw-semibold"
                    data-bs-toggle="collapse"
                    data-bs-target="#status5xx">
              Server Errors (5xx)
            </button>
          </h2>

          <div id="status5xx"
               class="accordion-collapse collapse"
               data-bs-parent="#statusCodeAccordion">
            <div class="accordion-body row g-4 align-items-center">

              <div class="col-md-6 text-center">
                <img src="<%= request.getContextPath() %>/resources/images/http-status-codes.png"
                     class="img-fluid rounded shadow zoomable"
                     data-bs-toggle="modal"
                     data-bs-target="#imageZoomModal"
                     alt="HTTP 5xx Status Codes">
              </div>

              <div class="col-md-6">
                <p>
                  <strong>5xx</strong> errors indicate server-side failures.
                </p>

                <pre class="code-block">
500 Internal Server Error → Unexpected failure
                </pre>

                <p class="mt-2">
                  These errors are handled centrally using
                  global exception mappers.
                </p>
              </div>

            </div>
          </div>
        </div>

      </div>

    </div>
  </div>
</div>


	<!-- ================= CENTRALIZED EXCEPTION HANDLING ================= -->
<div class="container py-5">

		 <div class="container mt-4">
         <div class="collapse" id="exceptionHandlingSection">
		
		  <h2 class="fw-bold text-center mb-4">
		    Centralized Exception Handling
		  </h2>		  
		
		  <p class="text-center text-muted mb-5">
		    How errors flow through the API and are transformed into
		    consistent, client-friendly responses
		  </p>
		 
		  <div class="accordion shadow-sm" id="exceptionAccordion">
		
		    <!-- WHY -->
		    <div class="accordion-item">
		      <h2 class="accordion-header">
		        <button class="accordion-button fw-semibold"
		                type="button"
		                data-bs-toggle="collapse"
		                data-bs-target="#exceptionWhy">
		          Why Centralized Exception Handling?
		        </button>
		      </h2>
		
		      <div id="exceptionWhy"
		           class="accordion-collapse collapse show"
		           data-bs-parent="#exceptionAccordion">
		        <div class="accordion-body">
		
		          <p>
		            In REST APIs, exceptions should <strong>never</strong> be handled
		            inside controllers. Instead, all errors are intercepted at a
		            single point and converted into meaningful HTTP responses.
		          </p>
		
		          <ul>
		            <li>No stack traces leaked to clients</li>
		            <li>Consistent error structure</li>
		            <li>Clear HTTP semantics (400, 404, 409, 500)</li>
		            <li>Clean separation of concerns</li>
		          </ul>
		
		        </div>
		      </div>
		    </div>
		
		    <!-- ERROR FLOW DIAGRAM -->
		    <div class="accordion-item">
		      <h2 class="accordion-header">
		        <button class="accordion-button collapsed fw-semibold"
		                type="button"
		                data-bs-toggle="collapse"
		                data-bs-target="#exceptionFlow">
		          Visual Error Flow (Request → Exception → Response)
		        </button>
		      </h2>
		
		      <div id="exceptionFlow"
		           class="accordion-collapse collapse"
		           data-bs-parent="#exceptionAccordion">
		        <div class="accordion-body">
		
		          <div class="row g-4 align-items-center">
		
		            <div class="col-md-6 text-center">
		              <img src="<%= request.getContextPath() %>/resources/images/exception/exception-flow-1.png"
		                   class="img-fluid rounded shadow zoomable"
		                   data-bs-toggle="modal"
		                   data-bs-target="#imageZoomModal"
		                   alt="REST Exception Flow Diagram">
		            </div>
		
		            <div class="col-md-6">
		              <p>
		                When a request reaches the API:
		              </p>
		
		              <ol>
		                <li>Client sends HTTP request</li>
		                <li>Resource method delegates logic</li>
		                <li>Exception is thrown</li>
		                <li>ExceptionMapper intercepts it</li>
		                <li>Standard JSON error is returned</li>
		              </ol>
		
		              <p class="mt-3">
		                This mirrors enterprise frameworks like Spring Boot,
		                but is implemented manually using JAX-RS best practices.
		              </p>
		            </div>
		
		          </div>
		
		        </div>
		      </div>
		    </div>
		
		    <!-- ERROR RESPONSE STRUCTURE -->
		    <div class="accordion-item">
		      <h2 class="accordion-header">
		        <button class="accordion-button collapsed fw-semibold"
		                type="button"
		                data-bs-toggle="collapse"
		                data-bs-target="#exceptionResponse">
		          Error Response Structure
		        </button>
		      </h2>
		
		      <div id="exceptionResponse"
		           class="accordion-collapse collapse"
		           data-bs-parent="#exceptionAccordion">
		        <div class="accordion-body">
		
		          <div class="row g-4">
		
		            <div class="col-md-6 text-center">
		              <img src="<%= request.getContextPath() %>/resources/images/exception/error-response-json.png"
		                   class="img-fluid rounded shadow zoomable"
		                   data-bs-toggle="modal"
		                   data-bs-target="#imageZoomModal"
		                   alt="Error Response JSON">
		            </div>
		
		            <div class="col-md-6">
		              <p>
		                All errors follow a predictable JSON format:
		              </p>
		
		              <pre class="code-block">
		{
		  "status": 500,
		  "message": "Internal Server Error"
		}
		              </pre>
		
		              <p>
		                This structure allows frontend and API consumers to
		                reliably parse and react to failures.
		              </p>
		            </div>
		
		          </div>
		
		        </div>
		      </div>
		    </div>
		
		    <!-- SPRING COMPARISON -->
		    <div class="accordion-item">
		      <h2 class="accordion-header">
		        <button class="accordion-button collapsed fw-semibold"
		                type="button"
		                data-bs-toggle="collapse"
		                data-bs-target="#exceptionComparison">
		          Framework Comparison (Spring-style Handling)
		        </button>
		      </h2>
		
		      <div id="exceptionComparison"
		           class="accordion-collapse collapse"
		           data-bs-parent="#exceptionAccordion">
		        <div class="accordion-body">
		
		          <div class="row g-4">
		
		            <div class="col-md-6 text-center">
		              <img src="<%= request.getContextPath() %>/resources/images/exception/spring-exception-flow.png"
		                   class="img-fluid rounded shadow zoomable"
		                   data-bs-toggle="modal"
		                   data-bs-target="#imageZoomModal"
		                   alt="Spring Boot Exception Flow">
		            </div>
		
		            <div class="col-md-6">
		              <p>
		                The architecture used in this project closely resembles
		                Spring Boot’s <code>@ControllerAdvice</code> mechanism.
		              </p>
		
		              <ul>
		                <li>Controller remains clean</li>
		                <li>Service throws domain exceptions</li>
		                <li>Global handler formats response</li>
		                <li>Client receives proper HTTP code</li>
		              </ul>
		
		              <p class="mt-3">
		                The difference is that here, everything is implemented
		                explicitly — giving full control and understanding.
		              </p>
		            </div>
		
		          </div>
		
		        </div>
		      </div>
		    </div>
		
		  </div>
		  </div>
</div>
</div>
			
							
	
<!-- ================= ROADMAP ================= -->

			<div class="container py-5">
			  <h2 class="fw-bold mb-4">Upcoming Enhancements</h2>
			
			  <div class="row">
			    <div class="col-md-8">
			      <ul class="fs-5">
			        <li>DAO and persistence layer</li>
			        <li>Transactions and batch operations</li>
			        <li>Security (Authentication and Authorization)</li>
			        <li>OpenAPI / Swagger documentation</li>
			        <li>Spring Boot migration</li>
			      </ul>
			    </div>
			  </div>
			</div>



<!-- ================= IMAGE ZOOM MODAL ================= -->
<div class="modal fade" id="imageZoomModal" tabindex="-1">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content bg-dark">

      <div class="modal-header border-0">
        <button type="button" class="btn-close btn-close-white"
                data-bs-dismiss="modal"></button>
      </div>

      <div class="modal-body d-flex justify-content-center align-items-center">
        <img id="zoomedImage" class="img-fluid">
      </div>

    </div>
  </div>
</div>

		<script>
		  document.addEventListener("DOMContentLoaded", function () {
		
		    const carouselElement = document.querySelector('#restVisualCarousel');
		    const carousel = new bootstrap.Carousel(carouselElement, {
		      interval: 4000,
		      ride: false,
		      pause: false
		    });
		
		    const observer = new IntersectionObserver(entries => {
		      entries.forEach(entry => {
		        if (entry.isIntersecting) {
		          carousel.cycle();   // ▶ start auto-slide
		        } else {
		          carousel.pause();   // ⏸ stop auto-slide
		        }
		      });
		    }, {
		      threshold: 0.6
		    });
		
		    observer.observe(carouselElement);
		  });
		  
		  
		  document.addEventListener("DOMContentLoaded", function () {

			    const carouselElement = document.getElementById("restVisualCarousel");
			    const carousel = new bootstrap.Carousel(carouselElement, {
			      interval: 4000,
			      ride: false,
			      pause: false
			    });

			    // Auto play only when visible
			    const observer = new IntersectionObserver(entries => {
			      entries.forEach(entry => {
			        entry.isIntersecting ? carousel.cycle() : carousel.pause();
			      });
			    }, { threshold: 0.6 });

			    observer.observe(carouselElement);

			    // Zoom logic
			    const zoomedImage = document.getElementById("zoomedImage");
			    document.querySelectorAll(".zoomable").forEach(img => {
			      img.addEventListener("click", () => {
			        zoomedImage.src = img.src;
			      });
			    });
			  });
		</script>

</body>
</html>
