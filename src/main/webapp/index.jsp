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
			      <div class="card h-100 shadow-sm border-0 text-center p-3 hover-card">
			        <i class="bi bi-arrow-left-right fs-1 text-success mb-3"></i>
			        <h6 class="fw-semibold">HTTP Methods</h6>
			        <p class="text-muted small">GET, POST, PUT, PATCH, DELETE</p>
			      </div>
			    </div>
			
			    <div class="col-md-3">
			      <div class="card h-100 shadow-sm border-0 text-center p-3 hover-card">
			        <i class="bi bi-check2-circle fs-1 text-info mb-3"></i>
			        <h6 class="fw-semibold">Status Codes</h6>
			        <p class="text-muted small">Semantic HTTP responses</p>
			      </div>
			    </div>
			
			    <div class="col-md-3">
			      <div class="card h-100 shadow-sm border-0 text-center p-3 hover-card">
			        <i class="bi bi-exclamation-triangle-fill fs-1 text-danger mb-3"></i>
			        <h6 class="fw-semibold">Error Handling</h6>
			        <p class="text-muted small">Centralized exception mapping</p>
			      </div>
			    </div>
			
			  </div>
			</div>
			
			
			<!-- ========Clicked visuval content====== --> 
			
				<div class="container mt-4">
				  <div class="collapse" id="restfulDesignContent">
				    <div class="card border-0 shadow-sm p-4 content-card">
				
				      <h4 class="fw-bold mb-3">Resource-Oriented API Design</h4>
				
				      <p>
				        In our Jersey REST API, we follow a
				        <strong>resource-oriented design</strong>, where URLs represent
				        <em>domain entities</em> rather than actions.
				      </p>
				
				      <p>
				        Each resource is identified by a stable URI and manipulated using
				        standard HTTP methods.
				      </p>
				
					      <pre class="code-block">
					GET    /players
					POST   /players
					GET    /players/{id}
					PUT    /players/{id}
					PATCH  /players/{id}
					DELETE /players/{id}
					      </pre>
				
				      <p>
				        This approach ensures predictability, scalability, and clean separation
				        between resource identity and behavior.
				      </p>
				
				    </div>
				  </div>
				</div>
							
			
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
